package gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;

public interface IHttpRequestFilter {

    void filterRequest(FullHttpRequest request, ChannelHandlerContext ctx);

}
