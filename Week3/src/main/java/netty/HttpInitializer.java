package netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import netty.handler.HttpHandler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        Config configs = new Config();
        ChannelPipeline p = ch.pipeline();
        List<String> items = (List<String>) configs.get("Handlers");
        for (String item : items) {
            p.addLast((ChannelHandler)Class.forName(item).getConstructor().newInstance());
        }
        //p.addLast(new HttpServerExpectContinueHandler());
        p.addLast(new HttpObjectAggregator(1024 * 1024));
    }
}
