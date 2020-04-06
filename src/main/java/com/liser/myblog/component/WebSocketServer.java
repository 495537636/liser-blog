package com.liser.myblog.component;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description: websocket服务类
 * @author: LiMG
 * @create: 2020-02-05 14:42:25
 **/
@Slf4j
@Component
@ServerEndpoint("/socket/{userId}")
public class WebSocketServer {

    /**
     * 存放会话的map集合
     */
    private static ConcurrentHashMap<String, WebSocketServer> socketMap = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 接收userId
     */
    private String userId = null;

    /**
     * 在线用户总数
     */
    private static int onlineCount = 0;

    /**
     * 会话开启方法
     *
     * @param session 连接会话
     * @param userId  用户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") String userId) {
        this.session = session;
        this.userId = userId;
        // 如果存在相同的用户连接，则移除再进行添加
        if (socketMap.containsKey(userId)) {
            socketMap.remove(userId);
        }
        socketMap.put(userId, this);
        try {
            // 连接成功，发送消息，增加在线人数
            addOnlineCount();
            sendMessage("用户" + userId + "加入群聊，当前在线人数：" + getOnlineCount() + "人", null);
        } catch (Exception e) {
            log.error("发送消息失败：{}", e.getMessage(), e);
        }
    }

    /**
     * 会话关闭方法
     */
    @OnClose
    public void onClose() {
        if (socketMap.containsKey(userId)) {
            socketMap.remove(userId);
            subOnlineCount();
            sendMessage("用户" + userId + "退出群聊，当前在线人数：" + getOnlineCount() + "人", null);
        }
        System.out.println("会话关闭");
    }

    /**
     * 接收到消息的方法
     */
    @OnMessage
    public void onMessage(Session session, String message) {
        if (StrUtil.isNotEmpty(message)) {
            JSONObject jsonObject = JSONObject.parseObject(message);
            String userId = jsonObject.getString("userId");
            String msg = jsonObject.getString("message");
            // 消息接收人
            String toUserId = jsonObject.getString("toUserId");
            sendMessage("用户" + userId + "说：" + msg, toUserId);
        }
    }

    /**
     * 报错的方法
     *
     * @param session   连接会话
     * @param throwable 异常对象
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("websocket报错，错误信息：" + throwable.getMessage());
    }

    /**
     * 发送消息
     * @param message   消息内容
     * @param toUserId  消息接收人
     */
    private static void sendMessage(String message, String toUserId) {
        try {
            /**
             * 如果消息接收人不为空，则发送消息给指定的人
             * 否则发送
             */
            if (StrUtil.isNotEmpty(toUserId)) {
                socketMap.get(toUserId).session.getBasicRemote().sendText(message);
            } else {
                for (String key : socketMap.keySet()) {
                    socketMap.get(key).session.getBasicRemote().sendText(message);
                }
            }
        } catch (IOException e) {
            log.error("发送消息失败：{}", e.getMessage(), e);
        }
    }

    /**
     * 获取当前在线总数
     * @return
     */
    private synchronized static int getOnlineCount() {
        return onlineCount;
    }

    /**
     * 增加在线总数
     */
    private synchronized static void addOnlineCount() {
        onlineCount++;
    }

    /**
     * 减少在线总数
     */
    private synchronized static void subOnlineCount() {
        onlineCount--;
    }

}
