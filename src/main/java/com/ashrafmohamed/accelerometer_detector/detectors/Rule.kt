package com.ashrafmohamed.accelerometer_detector.detectors

import android.hardware.SensorEvent

interface Rule {
    fun evaluate(event: SensorEvent): Boolean
}