package com.abc

import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

open class PlaygroundExtension @Inject constructor(objectFactory: ObjectFactory) {
    var enabled = true
    var someString = "default"
}