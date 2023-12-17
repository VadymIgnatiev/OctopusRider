package com.github.vadymignatiev.octopusrider

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class ChatAction : AnAction("Chat Action") {
    override fun actionPerformed(event: AnActionEvent) {
        val presenter = ChatPresenter()
        presenter.window.isVisible = true
    }
}