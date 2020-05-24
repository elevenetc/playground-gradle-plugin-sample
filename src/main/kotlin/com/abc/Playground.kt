package com.abc

import org.gradle.api.Plugin
import org.gradle.api.Project

class Playground : Plugin<Project> {
    override fun apply(project: Project) {
        val extension =
            project.extensions.create("playground", PlaygroundExtension::class.java, project.objects)


        val buildTask = project.getTasksByName("build", true).first()

        //val pgrTask = project.tasks.create("copyPlayground", PlaygroundTask::class.java, extension, buildTask)
        //buildTask.dependsOn.add(pgrTask)

        var start = 0L
        var end = 0L

        buildTask.doFirst {
            start = System.currentTimeMillis()
        }

        buildTask.doLast {
            end = System.currentTimeMillis()
            println("build time:")
            println("build time:")
            println("build time:")
            println("build time >>>> " + (end - start))
            println("build time:")
            println("build time:")
            println("build time:")
        }
    }
}