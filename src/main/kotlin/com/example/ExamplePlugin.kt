package com.example

import com.google.inject.Inject
import org.apache.logging.log4j.Logger
import org.spongepowered.api.Server
import org.spongepowered.api.event.Listener
import org.spongepowered.api.event.lifecycle.StartedEngineEvent
import org.spongepowered.plugin.builtin.jvm.Plugin

@Plugin("example")
class ExamplePlugin @Inject constructor(
    private val logger: Logger
) {
    @Listener
    fun onServerStart(event: StartedEngineEvent<Server>) {
        logger.info("Hello from example plugin!")
    }
}