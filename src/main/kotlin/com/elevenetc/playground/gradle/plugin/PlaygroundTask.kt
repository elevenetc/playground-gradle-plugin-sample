package com.elevenetc.playground.gradle.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

class PlaygroundTask @Inject constructor(
    private val extension: PlaygroundPluginExtension
) : DefaultTask() {
    @TaskAction
    fun run() {
        println("zed")
    }
}