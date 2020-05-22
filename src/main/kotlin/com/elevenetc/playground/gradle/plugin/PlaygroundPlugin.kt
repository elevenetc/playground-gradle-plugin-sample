package com.elevenetc.playground.gradle.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class PlaygroundPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension =
            project.extensions.create("playgroundPlugin", PlaygroundPluginExtension::class.java, project.objects)
    }
}