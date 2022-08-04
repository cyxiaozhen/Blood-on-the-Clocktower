package com.xs.botc.websocket;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 逻辑处理
 *
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class TextWebSocketHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	private static final Logger log = LoggerFactory.getLogger(TextWebSocketHandler.class);

	public TextWebSocketHandler() {
		super();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx,TextWebSocketFrame msg) throws Exception {
		log.info("接收到客户端的消息:[{}]", msg.text());
		// 如果是向客户端发送文本消息，则需要发送 TextWebSocketFrame 消息
		InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
		
		String hostName = inetSocketAddress.getHostName();
		String txtMsg = "["+inetSocketAddress.toString()+"][" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "] ==> "+ msg.text();
		log.info("收到参数 : {} , {}", txtMsg , hostName);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		deleteSession(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)throws Exception {
		ctx.close();
		log.error("服务器发生了异常:", cause);
		deleteSession(ctx);
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt)throws Exception {
		if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
			log.info("web socket 握手成功。");
			WebSocketServerProtocolHandler.HandshakeComplete handshakeComplete = (WebSocketServerProtocolHandler.HandshakeComplete) evt;
			String requestUri = handshakeComplete.requestUri();
			log.info("requestUri:[{}]", requestUri);
			String subproTocol = handshakeComplete.selectedSubprotocol();
			log.info("subproTocol:[{}]", subproTocol);
			handshakeComplete.requestHeaders().forEach(entry -> log.info("header key:[{}] value:[{}]",entry.getKey(), entry.getValue()));
		} else {
			super.userEventTriggered(ctx, evt);
		}
	}

	/**
	 * 心跳管理
	 *
	 * @email m18670240103@163.com
	 * @author: xz
	 * @date: 2022/8/4 周四
	 *
	 * @param ctx 对象
	 */
	public void deleteSession(ChannelHandlerContext ctx) {
		InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
		String ip = inetSocketAddress.toString();
		log.debug("客户端反注册   from {" + ip + "}");
		WebSocketSessionManage.channelMap.remove(ip);
		ctx.close();
	}
	
	
}
