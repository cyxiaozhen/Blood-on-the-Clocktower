package com.xs.botc.websocket;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @email m18670240103@163.com
 * @author: xz
 * @date: 2022/8/4 周四
 */
public class WebSocketSessionManage {
	
	//客户端组
    public  static ChannelGroup channelGroup;

    static {
        channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    }
    
    //存储ip和url
    public static ConcurrentMap<String, String> channelMap = new ConcurrentHashMap<>();
    
    //管理组
    public static ConcurrentMap<String, ChannelGroup> videoGroupMap = new ConcurrentHashMap<>();

}
