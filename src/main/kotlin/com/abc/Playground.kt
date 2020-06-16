package com.abc

import org.gradle.api.Plugin
import org.gradle.api.Project

class Playground : Plugin<Project> {
    override fun apply(project: Project) {

        val extension = project.extensions.create(
                "playground",
                PlaygroundExtension::class.java,
                project.objects
        )

        project.tasks.register("playground", PlaygroundTask::class.java)
                .configure {
                    it.description = "Playground: descrption"
                    it.group = "Playground: group"

                    if (extension.enabled) {

                        println("pgg: init")
                        val connectedTask = project.getTasksByName("connectedAndroidTest", true).first()

                        it.doFirst {
                            println("pgg: do first")

                            println("pgg: do first >>> " + connectedTask.name)

                        }


                        connectedTask.inputs.property("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")

                        it.dependsOn(connectedTask)
                    }
                }
    }

    private fun x(project: Project, extension: PlaygroundExtension) {
        val buildTask = project.getTasksByName("build", true).first()

        buildTask.doLast {

            if (extension.enabled) {
                println("playground enabled")
                println("playground value: ${extension.someString}")
            } else {
                println("playground disabled")
            }
        }
    }
}

