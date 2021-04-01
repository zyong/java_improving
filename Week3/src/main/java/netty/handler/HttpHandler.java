package netty.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.*;
import io.netty.util.ReferenceCountUtil;
import org.apache.http.Header;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Map;

import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class HttpHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {ctx.flush(); }

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String uri = fullRequest.uri();
            handlerTest(fullRequest, ctx, !uri.contains("/test"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    private void handlerTest(FullHttpRequest fullRequest, ChannelHandlerContext ctx, boolean other) {
        FullHttpResponse response = null;
        String value = "";
        try {
//            String value = "Hello, mark";
//            if (other) {
//                value = "Hello, others";
//            }
            HttpHeaders headers = fullRequest.headers();
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet httpGet = new HttpGet(fullRequest.uri());
            System.out.println("request url :" + fullRequest.uri());
            for (Map.Entry<String, String> entry: headers) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
            CloseableHttpResponse res = null;
            try {
                // 由客户端执行(发送)Get请求
                res = httpClient.execute(httpGet);
                // 从响应模型中获取响应实体
                HttpEntity responseEntity = res.getEntity();
                System.out.println("响应状态为:" + res.getStatusLine());
                if (responseEntity != null) {
                    value = EntityUtils.toString(responseEntity);
                }
            } catch (IOException e) {
                System.out.println("连接失败"+e.getMessage());
            } finally {
                try {
                    // 释放资源
                    if (httpClient != null) {
                        httpClient.close();
                    }
                    if (response != null) {
                        res.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Header[] resheaders = res.getAllHeaders();
            for (Header header : resheaders) {
                System.out.println(header.getName() + " : " + header.getValue());
            }

            response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(value.getBytes("UTF-8")));
            response.headers().set("Content-Type", res.getLastHeader("Content-Type").getValue());
            response.headers().setInt("Content-Length", response.content().readableBytes());

        } catch (Exception e) {
            System.out.println("处理出错:"+e.getMessage());
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
        } finally {
            if (fullRequest != null) {
                if (!HttpUtil.isKeepAlive(fullRequest)) {
                    ctx.write(response).addListener(ChannelFutureListener.CLOSE);
                } else {
                    response.headers().set(CONNECTION, KEEP_ALIVE);
                    ctx.write(response);
                }
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
