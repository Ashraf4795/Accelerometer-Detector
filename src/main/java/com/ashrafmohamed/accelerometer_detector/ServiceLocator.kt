package com.ashrafmohamed.accelerometer_detector

import android.hardware.SensorEvent
import com.ashrafmohamed.accelerometer_detector.detectors.shake_detector.ShakeDetector
import com.ashrafmohamed.accelerometer_detector.detectors.shake_detector.ShakeRule

object ServiceLocator {

    fun getShakeRule() = ShakeRule()
    fun getShakeDetector(callback: (event: SensorEvent) -> Unit) =
        ShakeDetector(getShakeRule(), callback)

}