package netty.handler;

import gateway.outbound.netty.HttpClientOutboundHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.ReferenceCountUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class NettyHttpHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(NettyHttpHandler.class);

    private Channel outboundChannel;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String uri = fullRequest.uri();
            handleTest(fullRequest, ctx, !uri.contains("/test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx, boolean flag) {
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
                    ch.pipeline().addLast(new HttpResponseDecoder());
                    // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
                    ch.pipeline().addLast(new HttpRequestEncoder());
                    //聚合
                    ch.pipeline().addLast(new HttpObjectAggregator(1024 * 10 * 1024));
                    ch.pipeline().addLast(new NettyInboundHandler(ctx, fullRequest));
                }
            });
            // Start the client.
            URL url = new URL(fullRequest.uri());
            logger.info("request url " + url);

            int port = url.getPort() == -1 ? 80 : url.getPort();
            ChannelFuture f = b.connect(url.getHost(), port).sync();
            outboundChannel = f.channel();
            f.channel().closeFuture().sync();

        } catch (InterruptedException | MalformedURLException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }


}
