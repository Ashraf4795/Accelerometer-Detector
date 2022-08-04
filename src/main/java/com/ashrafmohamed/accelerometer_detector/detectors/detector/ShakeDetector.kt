package com.ashrafmohamed.accelerometer_detector.detectors.detector

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import com.ashrafmohamed.accelerometer_detector.detectors.rules.Rule

class ShakeDetector (private val rule: Rule, private val callback: (event: SensorEvent)->Unit): SensorEventListener {


    override fun onSensorChanged(event: SensorEvent) {
        if (rule.evaluate(event))
            callback.invoke(event)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}