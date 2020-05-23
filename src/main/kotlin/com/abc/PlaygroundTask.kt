package com.abc

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

class PlaygroundTask @Inject constructor(
    private val extension: PlaygroundExtension
) : DefaultTask() {
    @TaskAction
    fun run() {
        println("zed")
    }
}