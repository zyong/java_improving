package gateway.outbound.netty;

import gateway.inbound.IOutboundHandler;
import gateway.router.RoundRobinHttpRouter;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpUtil;


import java.net.URL;
import java.util.List;

public class NettyHttpClientoutboundHandler implements IOutboundHandler {
    HttpClient client;
    RoundRobinHttpRouter router = new RoundRobinHttpRouter();
    ChannelHandlerContext ctx;
    List<String> backendUrls;

    public NettyHttpClientoutboundHandler(List<String> backends) {
        backendUrls = backends;
    }

    @Override
    public void handle(ChannelHandlerContext ctx, HttpRequest request) {
        this.ctx = ctx;
        client = new HttpClient(ctx);
        String backendUrl = router.route(backendUrls);
        try {
            URL url = new URL(backendUrl);
            int port = url.getPort() == -1 ? 80 : url.getPort();
            client.connect(url.getHost(), port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
