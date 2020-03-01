package com.loving.myblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @description: websocket配置类
 * @author: LiMG
 * @create: 2020-02-05 14:45:05
 **/
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter getServerEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
