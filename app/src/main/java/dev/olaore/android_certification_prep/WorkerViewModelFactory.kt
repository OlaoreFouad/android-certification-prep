package dev.olaore.android_certification_prep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.olaore.android_certification_prep.work_manager.BlurViewModel
import java.lang.IllegalArgumentException

@Suppress("IMPLICIT_CAST_TO_ANY")
class WorkerViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when(modelClass) {
            BlurViewModel::class.java -> BlurViewModel()
            else -> IllegalArgumentException(
                "Class argument passed in must be of type ViewModel"
            )
        } as T
    }

}