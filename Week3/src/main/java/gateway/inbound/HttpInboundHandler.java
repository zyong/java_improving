package gateway.inbound;

import gateway.filter.HttpHeaderFilter;
import gateway.filter.IHttpRequestFilter;
import gateway.filter.IHttpResponseFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private List<IHttpRequestFilter> requestFilters = new ArrayList<>();

    private List<IHttpResponseFilter> responseFilters = new ArrayList<>();

    private IOutboundHandler outboundHandler;

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /**
     * 1.调用过滤filter处理数据
     * 2.请求要转发给下游，调用outboundhandler处理分发
     *
     * @param ctx ChannelHandlerContext
     * @param msg Object
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        FullHttpRequest request = (FullHttpRequest) msg;
        handle(ctx, request);

    }

    private void handle(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        FullHttpRequest fullRequest = (FullHttpRequest)msg;
        // 数据filter
        if (requestFilters.size() > 0) {
            for (IHttpRequestFilter filter : requestFilters) {
                filter.filterRequest(fullRequest, ctx);
            }
        }

        outboundHandler.handle(ctx, fullRequest);
    }

    public void addObserver(HttpHeaderFilter filter) {
        if (filter instanceof IHttpRequestFilter) {
            requestFilters.add(filter);
        }
        if (filter instanceof IHttpResponseFilter) {
            responseFilters.add(filter);
        }
    }

    public void addOutboundHandler(IOutboundHandler outboundHandler) {
        this.outboundHandler = outboundHandler;
    }
}
