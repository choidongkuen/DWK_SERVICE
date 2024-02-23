package practice.websocket.controller

// 수신
data class ChattingMessage(val message: String)

// 응답
data class ChattingResponse(val message: String)
