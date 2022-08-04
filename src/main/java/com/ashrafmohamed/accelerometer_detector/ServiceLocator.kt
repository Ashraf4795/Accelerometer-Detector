package com.ashrafmohamed.accelerometer_detector

import android.hardware.SensorEvent
import com.ashrafmohamed.accelerometer_detector.detectors.detector.ShakeDetector
import com.ashrafmohamed.accelerometer_detector.detectors.rules.ShakeRule

object ServiceLocator {

    fun getShakeRule() = ShakeRule()
    fun getShakeDetector(callback: (event: SensorEvent) -> Unit) =
        ShakeDetector(getShakeRule(), callback)

}