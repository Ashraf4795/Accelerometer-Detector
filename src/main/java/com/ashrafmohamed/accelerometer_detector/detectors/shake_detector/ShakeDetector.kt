package com.ashrafmohamed.accelerometer_detector.detectors.shake_detector

import android.hardware.Sensor
import android.hardware.SensorEvent
import com.ashrafmohamed.accelerometer_detector.detectors.Detector
import com.ashrafmohamed.accelerometer_detector.detectors.Rule

class ShakeDetector(private val rule: Rule, private val callback: (event: SensorEvent) -> Unit) : Detector() {

    override fun onSensorChanged(event: SensorEvent) {
        if (rule.evaluate(event))
            callback.invoke(event)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        super.onAccuracyChanged(sensor, accuracy)

    }
}