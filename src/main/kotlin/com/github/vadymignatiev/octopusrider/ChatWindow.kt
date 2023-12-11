package com.github.vadymignatiev.octopusrider

import java.awt.*
import javax.swing.*

class ChatWindow : JFrame() {
    init {
        title = "Chat Window"
        setSize(400, 300)
        defaultCloseOperation = JFrame.DISPOSE_ON_CLOSE
        contentPane.layout = BorderLayout()
        val messageArea = JTextArea()
        messageArea.isEditable = false
        contentPane.add(JScrollPane(messageArea), BorderLayout.CENTER)
        val textField = JTextField()
        textField.addActionListener {
            val text = textField.text
            messageArea.append(text + "\n")
            textField.text = ""
        }
        contentPane.add(textField, BorderLayout.SOUTH)
        pack()
    }
}