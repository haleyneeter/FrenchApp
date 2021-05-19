package haley.neeter.kotlinfinal

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build


class Notificaton : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                CHANNEL_ID,
                "Channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is the first Channel "

            val manager = getSystemService(
                NotificationManager::class.java
            )
            manager.createNotificationChannel(channel1)

        }
    }

    companion object {
        const val CHANNEL_ID = "channel"

    }
}