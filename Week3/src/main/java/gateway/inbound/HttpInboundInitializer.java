package gateway.inbound;

import gateway.filter.HttpHeaderFilter;
import gateway.outbound.httpclient.HttpOutboundhandler;
import gateway.outbound.netty.HttpClientOutboundHandler;
import gateway.outbound.netty.NettyHttpClientoutboundHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

import java.util.Arrays;

public class HttpInboundInitializer extends ChannelInitializer {

    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline p = channel.pipeline();
        HttpInboundHandler handler = new HttpInboundHandler();
        handler.addObserver(new HttpHeaderFilter());
        String proxyServers = "http://127.0.0.1:8802,http://127.0.0.1:8803";
//        HttpOutboundhandler outboundHandler = new HttpOutboundhandler(Arrays.asList(proxyServers.split(",")));
        NettyHttpClientoutboundHandler outboundHandler = new NettyHttpClientoutboundHandler(Arrays.asList(proxyServers.split(",")));
        handler.addOutboundHandler(outboundHandler);

        p.addLast(new HttpServerCodec());
        p.addLast(new HttpObjectAggregator(1024 * 1024));

        p.addLast(handler);
    }
}
