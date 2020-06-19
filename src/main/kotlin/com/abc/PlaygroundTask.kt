package com.abc

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

open class PlaygroundTask @Inject constructor() : DefaultTask() {

    init {
        description = "Desk"
        group = "Play"
    }

    @TaskAction
    fun run() {

        println("RUNNING PLAYGROUND>>>>>")
        println("RUNNING PLAYGROUND>>>>>")
        println("RUNNING PLAYGROUND>>>>>")
        println("RUNNING PLAYGROUND>>>>>")
        println("RUNNING PLAYGROUND>>>>>")
        println("RUNNING PLAYGROUND>>>>>")
    }
}