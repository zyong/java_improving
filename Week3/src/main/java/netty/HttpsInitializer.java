package netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.*;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import netty.handler.HttpsHandler;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class HttpsInitializer extends ChannelInitializer<Channel> {
    final SslContext sslCtx;

    public HttpsInitializer() throws SSLException, FileNotFoundException {
        // Configure SSL.
        sslCtx = SslContextBuilder.forServer(new FileInputStream("/Users/zhaoyong/Develop/JAVA/java_improving/Week2/cert/server.crt"),
                new FileInputStream("/Users/zhaoyong/Develop/JAVA/java_improving/Week2/cert/pkcs8server.key"))
                .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
    }

    @Override
    protected void initChannel(Channel ch) throws Exception {
        SSLEngine sslEngine = sslCtx.newEngine(ch.alloc());
        ChannelPipeline pipeline = ch.pipeline();
        sslEngine.setUseClientMode(false);
        sslEngine.setNeedClientAuth(false);

        pipeline.addFirst("ssl", new SslHandler(sslEngine, true));
//        // 客户端接收到的是httpResponse响应，所以要使用HttpResponseDecoder进行解码
//        pipeline.addLast(new HttpResponseDecoder());
//        // 客户端发送的是httprequest，所以要使用HttpRequestEncoder进行编码
//        pipeline.addLast(new HttpRequestEncoder());

        //HttpServerCodec:将HTTP客户端请求转成HttpRequest对象，将HttpResponse对象编码成HTTP响应发送给客户端。
        pipeline.addLast("codec", new HttpServerCodec());
        //聚合
        pipeline.addLast(new HttpObjectAggregator(1024 * 10 * 1024));

        pipeline.addLast(new HttpsHandler());
    }
}
