package netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import netty.handler.HttpHandler;
import netty.handler.NettyHttpHandler;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();
        p.addLast("servercodec", new HttpServerCodec());
        //p.addLast(new HttpServerExpectContinueHandler());
//        p.addLast(new HttpObjectAggregator(1024 * 1024));
//        p.addLast(new HttpHandler());
        p.addLast(new NettyHttpHandler());

    }
}
