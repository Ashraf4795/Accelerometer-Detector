package com.ashrafmohamed.accelerometer_detector

import android.hardware.SensorEvent
import com.ashrafmohamed.accelerometer_detector.detectors.jump_detector.JumpDetector
import com.ashrafmohamed.accelerometer_detector.detectors.jump_detector.JumpRule
import com.ashrafmohamed.accelerometer_detector.detectors.shake_detector.ShakeDetector
import com.ashrafmohamed.accelerometer_detector.detectors.shake_detector.ShakeRule

object ServiceLocator {

    private fun getShakeRule() = ShakeRule()
    private fun getJumpRule() = JumpRule()

    fun getShakeDetector(callback: (event: SensorEvent) -> Unit) =
        ShakeDetector(getShakeRule(), callback)

    fun getJumpDetector(callback: (event: SensorEvent) -> Unit) =
        JumpDetector(getJumpRule(), callback)

}