package com.github.vadymignatiev.octopusrider

import javax.swing.*
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyleConstants
import java.awt.BorderLayout
import java.awt.Color
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlinx.coroutines.*
import kotlinx.coroutines.swing.Swing
import com.aallam.openai.api.chat.*
import com.aallam.openai.api.model.ModelId
import com.aallam.openai.client.OpenAI
import kotlinx.serialization.json.*

class ChatWindow(val presenter: ChatPresenter) : JFrame() {

    private val messageArea = JTextPane()

    init {
        title = "Chat Window"
        setSize(800, 600)
        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        contentPane.layout = BorderLayout()
        messageArea.isEditable = false
        contentPane.add(JScrollPane(messageArea), BorderLayout.CENTER)

        val textField = JTextField()
        textField.addActionListener {
            val text = textField.text
            appendMessage(text, Color.BLACK)
            presenter.sendMessage(text)
            textField.text = ""
        }

        contentPane.add(textField, BorderLayout.SOUTH)

        addWindowListener(object : WindowAdapter() {
            override fun windowClosing(e: WindowEvent?) {
                presenter.coroutineScope.cancel()
                super.windowClosing(e)
            }
        })

        pack()
    }

    fun appendMessage(message: String, color: Color) {
        val doc = messageArea.styledDocument
        val style = SimpleAttributeSet()
        StyleConstants.setForeground(style, color)
        doc.insertString(doc.length, "$message\n", style)
    }
}