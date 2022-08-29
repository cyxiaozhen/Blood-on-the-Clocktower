package com.xs.botc.websocket;

import com.xs.botc.websocket.thread.ClientHeartbeatHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketFrameAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketServerCompressionHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 长连接
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
@Component
public class WebSocketServer {

    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    @Bean
    public void start(){
        initStartServer(9527);
    }

    public void initStartServer(int port) {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new LoggingHandler(LogLevel.TRACE))
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                            		//.addLast(new IdleStateHandler(5, 5, 0, TimeUnit.MINUTES))
                                    .addLast(new LoggingHandler(LogLevel.DEBUG))
                                    // HttpRequestDecoder和HttpResponseEncoder的一个组合，针对http协议进行编解码
                                    .addLast(new HttpServerCodec())
                                    // 分块向客户端写数据，防止发送大文件时导致内存溢出， channel.write(new ChunkedFile(new File("bigFile.mkv")))
                                    .addLast(new ChunkedWriteHandler())
                                    // 将HttpMessage和HttpContents聚合到一个完成的 FullHttpRequest或FullHttpResponse中,具体是FullHttpRequest对象还是FullHttpResponse对象取决于是请求还是响应
                                    // 需要放到HttpServerCodec这个处理器后面
                                    .addLast(new HttpObjectAggregator(1024))
                                    // webSocket 数据压缩扩展，当添加这个的时候WebSocketServerProtocolHandler的第三个参数需要设置成true
                                    .addLast(new WebSocketServerCompressionHandler())
                                    // 聚合 websocket 的数据帧，因为客户端可能分段向服务器端发送数据
                                    // https://github.com/netty/netty/issues/1112 https://github.com/netty/netty/pull/1207
                                    .addLast(new WebSocketFrameAggregator(1024 * 1024))
                                    // 服务器端向外暴露的 web socket 端点，当客户端传递比较大的对象时，maxFrameSize参数的值需要调大
                                    .addLast(new WebSocketServerProtocolHandler("/startGame", null, true, 1048576))
                                    // 自定义处理器 - 处理 web socket 文本消息
                                    .addLast(new TextWebSocketHandler())
                                    // 自定义处理器 - 处理 web socket 二进制消息
                                    .addLast(new BinaryWebSocketFrameHandler())
                                    //自定义心跳包处理器
                            		.addLast(new ClientHeartbeatHandler());
                        }
                    });
            ChannelFuture channelFuture = bootstrap.bind(port).sync();
            log.info("webSocket server listen on port : [{}]", port);
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
        	log.error("{} 端口服务启动失败",port);
        	log.error(e.getMessage(),e);
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
