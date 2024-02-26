package com.websocket.stomp.config

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

// STOMP 을 통한 웹 소켓 설정(내부 브로커)
@Configuration
@EnableWebSocketMessageBroker
class WebSocketServerConfiguration : WebSocketMessageBrokerConfigurer {
    companion object {
        private const val ENDPOINT = "/hello-websocket-chatting" // 클라이언트 초기 웹 소켓 접속 앤드포인트

        private const val SUB_PREFIX = "/topic" // 구독 앤드포인트 prefix
        private const val PUB_PREFIX = "/app" // 발행 앤드포인트 prefix
    }

    // message broker(exchange) 설정
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        // 클라이언트가 구독 가능한 앤드포인트 prefix
        registry.enableSimpleBroker(SUB_PREFIX)
        // 발행 가능한 앤드포인트 prefix
        registry.setApplicationDestinationPrefixes(PUB_PREFIX)
    }

    // web socket 앤드포인트
    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry
            // 웹 소켓 앤드포인트(클라이언트가 웹 소켓 서버와 연결 시 사용할 엔드포인트)
            .addEndpoint(ENDPOINT)
            .setAllowedOriginPatterns("*")
    }
}
