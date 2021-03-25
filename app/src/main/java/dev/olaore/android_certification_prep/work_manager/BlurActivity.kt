package dev.olaore.android_certification_prep.work_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.olaore.android_certification_prep.R
import dev.olaore.android_certification_prep.utils.obtainViewModelInWorker

class BlurActivity : AppCompatActivity() {

    private lateinit var viewModel: BlurViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blur)

        viewModel = obtainViewModelInWorker(BlurViewModel::class.java)

    }
}