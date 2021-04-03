package netty.handler;

import gateway.outbound.netty.HttpClientOutboundHandler;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NettyInboundHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(HttpClientOutboundHandler.class);

    ChannelHandlerContext serverCtx;
    FullHttpRequest serverRequest;

    public NettyInboundHandler(ChannelHandlerContext ctx, FullHttpRequest request) {
        serverRequest = request;
        serverCtx = ctx;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(serverRequest);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            logger.info("logger write msg to client");
            FullHttpResponse httpResponse = (FullHttpResponse) msg;
            serverCtx.writeAndFlush(httpResponse);
            ctx.channel().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
