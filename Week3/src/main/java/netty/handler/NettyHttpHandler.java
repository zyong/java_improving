package netty.handler;

import gateway.outbound.netty.HttpClientOutboundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class NettyHttpHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(NettyHttpHandler.class);
    //目标主机的channel
    private Channel remoteChannel;
    // 代理服务器channel
    private Channel clientChannel;

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().remove("servercodec");
    }

    public void channelActive(ChannelHandlerContext ctx) {
        clientChannel = ctx.channel();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws MalformedURLException, URISyntaxException {
        if (remoteChannel.isWritable()) {
            remoteChannel.writeAndFlush(msg);
            return;
        }

        // disable AutoRead until remote connection is ready
        clientChannel.config().setAutoRead(false);

        if (!(msg instanceof DefaultHttpRequest)) {
            ctx.fireChannelRead(msg);
            return;
        }
        DefaultHttpRequest httpRequest = (DefaultHttpRequest) msg;

        final Channel inboundChannel = ctx.channel();

        String url = httpRequest.uri();
        if (url.contains("443")) {
            url = url.startsWith("https://") ? url : "https://" + url;
        } else {
            url = url.startsWith("http://") ? url : "http://" + url;
        }
        URI uri = new URI(url);
        int port = uri.getPort();
        if (port == -1) {
            port = 80;
        }

        Bootstrap b = new Bootstrap();
        b.group(ctx.channel().eventLoop());
        b.channel(ctx.channel().getClass());
        b.option(ChannelOption.SO_KEEPALIVE, true);
        if (httpRequest.method().name().equals("CONNECT")) {
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ProxyHandler(ctx));
                }
            });

            ChannelFuture f = b.connect(uri.getHost(), port);
            remoteChannel = f.channel();
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (future.isSuccess()) {
                        // connection complete start to read first data
                        clientChannel.write(msg);
                    } else {
                        // Close the connection if the connection attempt has failed.
                        remoteChannel.close();
                    }
                }
            });


        } else {
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    //聚合
                    ch.pipeline().addLast(new HttpObjectAggregator(1024 * 10 * 1024));
                    ch.pipeline().addLast(new NettyInboundHandler(ctx, httpRequest));
                }
            });

            ChannelFuture f = b.connect(uri.getHost(), port);
            remoteChannel = f.channel();
            f.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) {
                    if (future.isSuccess()) {
                        // connection complete start to read first data
                        clientChannel.read();
                    } else {
                        // Close the connection if the connection attempt has failed.
                        clientChannel.close();
                    }
                }
            });
        }


    }

    private class ProxyHandler extends ChannelInboundHandlerAdapter {

        ChannelHandlerContext clientCtx;

        public ProxyHandler(ChannelHandlerContext ctx) {
            clientCtx = ctx;
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) {
            ctx.fireChannelActive();
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            clientCtx.write(msg);
        }
    }
}




