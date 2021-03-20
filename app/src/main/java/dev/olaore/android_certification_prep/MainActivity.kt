package dev.olaore.android_certification_prep

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

@Suppress("SameParameterValue")
class MainActivity : AppCompatActivity() {

    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var channel1Button: Button
    private lateinit var channel2Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.notification_title)
        description = findViewById(R.id.notification_description)
        channel1Button = findViewById(R.id.send_notification_channel_1)
        channel2Button = findViewById(R.id.send_notification_channel_2)

        channel1Button.setOnClickListener {
            val valid = performValidation()
            if (valid) {
                showNotification(title.text.toString(), description.text.toString(), CHANNEL_ID_1)
            }
        }

        channel2Button.setOnClickListener {
            val valid = performValidation()
            if (valid) {
                showNotification(title.text.toString(), description.text.toString(), CHANNEL_ID_2)
            }
        }


    }

    private fun showNotification(title: String, message: String, channelId: String) {
        val builder: Notification.Builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, channelId)
        } else {
            Notification.Builder(this)
        }

        builder.setSmallIcon(R.drawable.ic_message)
            .setContentTitle(title)
            .setContentText(message)
            .setCategory(Notification.CATEGORY_MESSAGE)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, builder.build())
    }

    private fun performValidation(): Boolean {
        if (title.text.toString().isEmpty() || description.text.toString().isEmpty()) {
            showToast("Fill in the title and description fields please")
            return false
        }
        return true
    }

    private fun showPopups() {
        showToast("This is the first message")

        Handler().postDelayed({
            showToast("This shows after 3 seconds")
        }, 3000)

        Handler().postDelayed({
            showSnackbar("This shows after 5 seconds")
        }, 5000)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun showSnackbar(message: String) {
        Snackbar.make(
                findViewById(R.id.linear_layout), message, Snackbar.LENGTH_LONG
        ).show()
    }
}