package com.ashrafmohamed.accelerometer_detector.detectors.detector

import android.hardware.SensorEvent
import com.ashrafmohamed.accelerometer_detector.detectors.Detector
import com.ashrafmohamed.accelerometer_detector.detectors.rules.Rule
// this is implementation of a detection of sensore event.
class ShakeDetector(private val rule: Rule, private val callback: (event: SensorEvent) -> Unit) : Detector() {

    override fun onSensorChanged(event: SensorEvent) {
        if (rule.evaluate(event))
            callback.invoke(event)
    }
}