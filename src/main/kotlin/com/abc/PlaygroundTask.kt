package com.abc

import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

open class PlaygroundTask @Inject constructor(
    private val extension: PlaygroundExtension
) : DefaultTask() {
    @TaskAction
    fun run() {

    }
}