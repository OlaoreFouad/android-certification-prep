package dev.olaore.android_certification_prep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

@Suppress("SameParameterValue")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
                findViewById(R.id.text_view), message, Snackbar.LENGTH_LONG
        ).show()
    }
}