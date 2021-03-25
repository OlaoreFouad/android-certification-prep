package dev.olaore.android_certification_prep.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.olaore.android_certification_prep.WorkerViewModelFactory

fun <T : ViewModel> AppCompatActivity.obtainViewModelInWorker(modelClass: Class<T>) : T {

    val viewModelFactory = WorkerViewModelFactory()
    return ViewModelProvider(this, viewModelFactory).get(modelClass)

}