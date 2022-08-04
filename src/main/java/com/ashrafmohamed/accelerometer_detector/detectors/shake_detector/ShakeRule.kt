package com.ashrafmohamed.accelerometer_detector.detectors.shake_detector

import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.ashrafmohamed.accelerometer_detector.detectors.Rule
import kotlin.math.sqrt

class ShakeRule: Rule {
    private var acceleration = 10f
    private var currentAcceleration = SensorManager.GRAVITY_EARTH
    private var lastAcceleration = SensorManager.GRAVITY_EARTH

    override fun evaluate(event: SensorEvent): Boolean {
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]
        lastAcceleration = currentAcceleration
        currentAcceleration = sqrt((x * x + y * y + z * z).toDouble()).toFloat()
        val delta: Float = currentAcceleration - lastAcceleration
        acceleration = acceleration * 0.9f + delta

        if (acceleration > 12) {
            return true
        }
        return false
    }
}