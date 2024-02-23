package com.websocket.stomp.config

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.socket.messaging.SessionConnectEvent
import org.springframework.web.socket.messaging.SessionConnectedEvent
import org.springframework.web.socket.messaging.SessionDisconnectEvent
import org.springframework.web.socket.messaging.SessionSubscribeEvent
import org.springframework.web.socket.messaging.SessionUnsubscribeEvent


// 실제 메세지 처리
@Component
class STOMPWebSocketEventHandler {
    private val logger = KotlinLogging.logger {}

    // 연결 시
    @EventListener
    fun handleWebSocketSessionConnectEventListener(event: SessionConnectEvent) {
        logger.info { ">>> Received a SessionConnectEvent" }
    }

    // 구독 시
    @EventListener
    fun handleWebSocketSessionSubscribeEventListener(event: SessionSubscribeEvent) {
        logger.info { ">>> Received a SessionSubscribeEvent" }
    }

    // 구독 해제 시
    fun handleWebSocketSessionUnsubscribeEventListener(event: SessionUnsubscribeEvent) {
        logger.info { ">>> Received a SessionUnsubscribeEvent" }
    }

    // 연결 받을
    @EventListener
    fun handleWebSocketSessionConnectedEventListener(event: SessionConnectedEvent) {
        logger.info { ">>> Received a SessionConnectedEvent" }
    }

    // 연결 해제 시
    @EventListener
    fun handlerWebSocketSessionDisconnectedEventListener(event: SessionDisconnectEvent) {
        logger.info { ">>> Received a SessionDisconnectEvent" }
    }

}
