package com.ashrafmohamed.accelerometer_detector

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class Accelerometer (private val context: Context){

    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerometerSensor: Sensor = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)[0]
    private val disposal: ArrayList<SensorEventListener> = arrayListOf()

    fun detectShake(listener: (event: SensorEvent)-> Unit) {
        val shakeDetector = ServiceLocator.getShakeDetector(listener)
        disposal.add(shakeDetector)
        sensorManager.registerListener(shakeDetector, accelerometerSensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    fun clear() {
        disposal.forEach {
            sensorManager.unregisterListener(it)
        }
    }

}