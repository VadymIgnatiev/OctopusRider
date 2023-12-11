package com.github.vadymignatiev.octopusrider

import com.intellij.ide.BrowserUtil
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class OrderFoodAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        // replace the URL with whatever you like :)
        BrowserUtil.browse("https://www.10bis.co.il/")
    }

}