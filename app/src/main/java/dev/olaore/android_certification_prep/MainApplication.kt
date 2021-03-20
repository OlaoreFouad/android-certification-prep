package dev.olaore.android_certification_prep

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

const val CHANNEL_ID_1 = "channel1"
const val CHANNEL_ID_2 = "channel2"

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        createNotificationChannels()
    }

    private fun createNotificationChannels() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_ID_1, "First Channel", NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "First Channel Description - High Importance"
            val channel2 = NotificationChannel(
                CHANNEL_ID_2, "Second Channel", NotificationManager.IMPORTANCE_LOW
            )
            channel2.description = "Second Channel Description - Low Importance"

            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)!!
            notificationManager.createNotificationChannel(channel1)
            notificationManager.createNotificationChannel(channel2)
        }

    }

}