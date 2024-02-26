package practice.websocket.handler

import com.fasterxml.jackson.databind.ObjectMapper
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.core.annotation.Order
import org.springframework.messaging.simp.stomp.StompCommand
import org.springframework.messaging.simp.stomp.StompHeaders
import org.springframework.messaging.simp.stomp.StompSession
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
@Order(value = 1)
class ClientWebSocketStompSessionHandler(
    val objectMapper: ObjectMapper,
) : StompSessionHandlerAdapter() {
    companion object {
        private const val SUB_PREFIX = "topic"
        private const val PUB_PREFIX = "app"

        private const val SUBSCRIPTION_TOPIC = "/${SUB_PREFIX}/chatting" // 구독 앤드포인트
        private const val PUBLISH_DEST = "/${PUB_PREFIX}/chatting-message" // 발행 앤드포인트

        private val logger = KotlinLogging.logger {}
    }

    // 메세지(frame) 수신
    override fun handleFrame(
        headers: StompHeaders,
        payload: Any?,
    ) {
        logger.info { ">>> handleFrame, $headers" }

        // 구독한 채널의 메세지 수신
        val responseRawMessage = String(payload as ByteArray)

        val responseMessage: ResponseMessage =
            objectMapper.readValue(responseRawMessage, ResponseMessage::class.java)

        logger.info { "content = ${responseMessage.content}" }
    }

    // 메세지 데이터 유형
    override fun getPayloadType(headers: StompHeaders): Type {
        return Any::class.java
    }

    // 연결 후
    override fun afterConnected(
        session: StompSession,
        connectedHeaders: StompHeaders,
    ) {
        logger.info { ">>> After Connected" }

        // 구독
        session.subscribe(SUBSCRIPTION_TOPIC, this)

        // 보낼 내용
        val params: MutableMap<String, Any> = HashMap()
        params["message"] = "반갑습니다. 저는 ${session.sessionId} 클라이언트입니다."

        // 메시지 발신
        session.send(PUBLISH_DEST, params)
        logger.info { "params = $params" }
    }

    override fun handleException(
        session: StompSession,
        command: StompCommand?,
        headers: StompHeaders,
        payload: ByteArray,
        exception: Throwable,
    ) {
        logger.info { ">>> handleException" }
        logger.info { "exception: $exception" }
    }

    override fun handleTransportError(
        session: StompSession,
        exception: Throwable,
    ) {
        logger.info { ">>> handleTransportError, ${exception.message}" }
    }
}
