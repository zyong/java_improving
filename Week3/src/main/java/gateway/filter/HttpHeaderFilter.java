package gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public class HttpHeaderFilter implements IHttpRequestFilter, IHttpResponseFilter {
    @Override
    public void filterResponse(FullHttpResponse response, ChannelHandlerContext ctx) {
        response.headers().set("from", "netty");
    }

    @Override
    public void filterRequest(FullHttpRequest request, ChannelHandlerContext ctx) {
        request.headers().set("to", "proxy");
    }
}
