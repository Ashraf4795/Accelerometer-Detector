package com.ashrafmohamed.accelerometer_detector.detectors.jump_detector

import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.ashrafmohamed.accelerometer_detector.detectors.Rule
import kotlin.math.sqrt

class JumpRule: Rule {

    private var acceleration = 10f
    private var currentAcceleration = SensorManager.GRAVITY_EARTH
    private var lastAcceleration = SensorManager.GRAVITY_EARTH

    override fun evaluate(event: SensorEvent): Boolean {
        val y = event.values[1]
        lastAcceleration = currentAcceleration
        currentAcceleration = sqrt((y * y).toDouble()).toFloat()
        val delta: Float = currentAcceleration - lastAcceleration
        acceleration = acceleration * 0.9f + delta

        if (acceleration > SensorManager.GRAVITY_EARTH) {
            return true
        }
        return false    }
}