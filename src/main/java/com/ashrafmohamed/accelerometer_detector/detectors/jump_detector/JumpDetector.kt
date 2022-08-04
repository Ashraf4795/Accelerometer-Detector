package com.ashrafmohamed.accelerometer_detector.detectors.jump_detector

import android.hardware.SensorEvent
import android.hardware.SensorManager
import com.ashrafmohamed.accelerometer_detector.detectors.Detector
import com.ashrafmohamed.accelerometer_detector.detectors.Rule

class JumpDetector(
    private val jumpRule: Rule,
    private val callback: (event: SensorEvent) -> Unit
): Detector() {

    override fun onSensorChanged(event: SensorEvent) {
        if (jumpRule.evaluate(event))
            callback.invoke(event)
    }

}