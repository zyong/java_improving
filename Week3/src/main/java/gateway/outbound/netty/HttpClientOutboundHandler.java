package gateway.outbound.netty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class HttpClientOutboundHandler extends ChannelInboundHandlerAdapter {
    private Logger logger = LoggerFactory.getLogger(HttpClientOutboundHandler.class);

    ChannelHandlerContext serverCtx;

    public HttpClientOutboundHandler(ChannelHandlerContext ctx) {
        serverCtx = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("logger write msg to client");
        serverCtx.channel().writeAndFlush(msg);
    }
}
