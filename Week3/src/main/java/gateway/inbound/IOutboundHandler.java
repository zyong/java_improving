package gateway.inbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;

public interface IOutboundHandler {
    public void handle(ChannelHandlerContext ctx, HttpRequest request);
}
