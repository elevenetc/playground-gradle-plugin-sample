package com.abc

import org.gradle.api.Plugin
import org.gradle.api.Project

class Playground : Plugin<Project> {
    override fun apply(project: Project) {
        val extension =
            project.extensions.create("playground", PlaygroundExtension::class.java, project.objects)
    }
}