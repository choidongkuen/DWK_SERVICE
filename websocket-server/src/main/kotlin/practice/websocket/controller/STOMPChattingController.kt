package practice.websocket.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils


@Controller
class STOMPChattingController {

    private val logger = KotlinLogging.logger {}

    // 일반적인 Controller 유사
    @MessageMapping("/chatting-message")
    @SendTo("/topic/chatting") // 내부 메시지 브로커 전달
    fun chatting(chattingMessage: ChattingMessage): ChattingResponse {
        logger.info { ">>> Received Message : ${chattingMessage.message}" }
        return ChattingResponse(HtmlUtils.htmlEscape(chattingMessage.message))
    }
}
