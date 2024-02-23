package practice.websocket.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.converter.MappingJackson2MessageConverter
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSessionHandler
import org.springframework.web.socket.client.WebSocketClient
import org.springframework.web.socket.client.standard.StandardWebSocketClient
import org.springframework.web.socket.messaging.WebSocketStompClient
import practice.websocket.handler.ClientWebSocketStompSessionHandler

// WebSocketClient
// : 웹 소켓 서버에게 구독을 요청하며, 웹 소켓 연결을 유지한다.
@Configuration
class WebSocketClientConfiguration {
    companion object {
        private const val ENDPOINT = "ws://localhost:8070/hello-websocket-chatting"
    }

    @Bean
    fun webSocketStompClient(
        webSocketStompClient: WebSocketStompClient,
        stompSessionHandler: StompSessionHandler,
    ): WebSocketStompClient {

        webSocketStompClient.messageConverter = MappingJackson2MessageConverter()

        // 헤더 설정 방법
        val stompHeaders = StompHeaders()
        stompHeaders.add("name", "choi")

        val urlVariables = arrayOf<Any>()
        webSocketStompClient.connectAsync(ENDPOINT, null, stompHeaders, stompSessionHandler, urlVariables)

        return webSocketStompClient


    }

    @Bean
    fun webSocketClient(): WebSocketStompClient? {
        val webSocketClient: WebSocketClient = StandardWebSocketClient()
        return WebSocketStompClient(webSocketClient)
    }


    @Bean
    fun stompSessionHandler(objectMapper: ObjectMapper): StompSessionHandler? {
        return ClientWebSocketStompSessionHandler(objectMapper)

    }
}
