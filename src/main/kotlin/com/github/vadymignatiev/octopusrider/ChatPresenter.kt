package com.github.vadymignatiev.octopusrider

import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.serialization.json.*
import java.awt.Color
import javax.swing.SwingWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatPresenter {
    private val token = "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"
    private val openAI = OpenAI(token)
    private val modelId = ModelId("gpt-3.5-turbo-1106")
    private val chatMessages = mutableListOf<ChatMessage>()

    val coroutineScope = CoroutineScope(Dispatchers.Main)

    val window = ChatWindow(this)

    init { window.isVisible = true }

    fun sendMessage(userMessage: String) {
        val userChatMessage = ChatMessage(ChatRole.User, userMessage)
        chatMessages.add(userChatMessage)

        coroutineScope.launch {
            val serviceResponse = sendToService(userMessage)
            window.appendMessage(serviceResponse, Color.BLUE)
            val serviceChatMessage = ChatMessage(ChatRole.System, serviceResponse)
            chatMessages.add(serviceChatMessage)
        }
    }

    private suspend fun sendToService(message: String): String {
        val request = chatCompletionRequest {
            model = modelId
            messages = chatMessages
        }
        val response = openAI.chatCompletion(request)
        return response.choices.first().message.content.orEmpty()
    }

}