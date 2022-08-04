package com.ashrafmohamed.accelerometer_detector.detectors

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener

abstract class Detector: SensorEventListener {
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
}