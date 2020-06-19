package com.abc

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
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
            .configure { it ->

                if (extension.enabled) {

                    it.doFirst {
                        val defaultConfig = project.configurations.getByName("default")

                    }


                    println("pgg: init")
                    println("P: current: " + project.name)
                    println("P: root: " + project.rootProject.name)

                    //val androidExtension = project.extensions.getByName("android")
                    val androidExtension: BaseAppModuleExtension =
                        project.extensions.getByName("android") as BaseAppModuleExtension
                    set(androidExtension)
                    if (androidExtension == null) {
                        println("NO ANDROID EXTE")
                    } else {
                        println("ANDROID EXTE>>> $androidExtension")

                    }

                    project.properties.forEach { t, any ->
                        //println("prope key: "+ t)
                    }
                    //project.rootProject.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")

                    val connectedTask = project.getTasksByName("connectedAndroidTest", true).first()

                    it.doFirst {
                        println("pgg: do first")
                        println("pgg: do first >>> " + connectedTask.name)
                    }

                    project.configurations.forEach {
                        //println("CONFIG NAME: " + it.name)
                    }

                    println("CONFIGS SIZE: " + project.configurations.size)

                    connectedTask.doFirst {

//                            androidExtension.defaultConfig {
//                                it.testInstrumentationRunnerArgument("annotation", "com.elevenetc.android.flat.performance.PerformanceTest")
//                            }
                        //androidExtension.defaultConfig.testInstrumentationRunnerArguments["annotation"] = "com.elevenetc.android.flat.performance.PerformanceTest"

                        //setField(androidExtension)
                        //println("PROPERTY SETTTTT")
                        //project.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")
                    }

                    //project.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")

//                        connectedTask.doFirst {
//                            project.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")
//                        }

//                        it.doFirst {
//                            project.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")
//                        }

                    //connectedTask.property()
                    //project.setProperty("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")

                    //connectedTask.inputs.property("android.testInstrumentationRunnerArguments.annotation", "com.elevenetc.android.flat.performance.PerformanceTest")
                    //connectedTask.setProperty("-P", "android.testInstrumentationRunnerArguments.annotation=com.elevenetc.android.flat.performance.PerformanceTest")

                    it.dependsOn(connectedTask)
                }
            }
    }

    fun set(androidExtension: BaseAppModuleExtension) {
        println("SETTING ANNOTATION")
        androidExtension.defaultConfig.testInstrumentationRunnerArguments["annotation"] =
            "com.elevenetc.android.flat.performance.PerformanceTest"
    }

    val debug = false

    private fun setField(obj: Any) {
        val javaClass = obj.javaClass

        if (debug) {
            println("Object inspection")
            println("name: " + javaClass.simpleName)
            println("d fields count: " + javaClass.declaredClasses.size)
            println("fields count: " + javaClass.fields.size)
            println("methods count: " + javaClass.methods.size)
            println("d methods count: " + javaClass.declaredMethods.size)
            println("\n")
        }



        javaClass.declaredMethods.forEach {

            if (debug) {
                println("\n")
                println("method: " + it.name)
                println("method: isAccessible: " + it.isAccessible)
                println("method: isSynthetic: " + it.isSynthetic)
                println("method: returnType: " + it.returnType)
                println("method: defaultValue: " + it.defaultValue)
                println("method: isVarArgs: " + it.isVarArgs)
            }



            if (it.name == "getDefaultConfig") {
                it.isAccessible = true
                try {
                    val defaultConfig = it.invoke(obj)
                    setField(defaultConfig)
                } catch (e: Throwable) {
                    e.printStackTrace()
                }
                return
                //printFields(invoke)
            }

            if (it.name == "setTestInstrumentationRunnerArguments") {
                val map = HashMap<String, String>()
                map["annotation"] = "com.elevenetc.android.flat.performance.PerformanceTest"
                it.invoke(obj, map)
                println("ANNOTATION SET")
                println("ANNOTATION SET")
                println("ANNOTATION SET")
                return
            }
        }

        javaClass.fields.forEach {
            println("field: " + it.name)
        }

        javaClass.declaredClasses.forEach {
            println("field: " + it.name)
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

