package com.elevenetc.playground.gradle.plugin

import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

class PlaygroundPluginExtension @Inject constructor(objectFactory: ObjectFactory) {
    var enabled = true
}