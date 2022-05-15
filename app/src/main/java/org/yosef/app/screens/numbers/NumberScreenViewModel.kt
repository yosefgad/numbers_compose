package org.yosef.app.screens.numbers

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.yosef.app.data.DataOrException
import org.yosef.app.models.Numbers
import org.yosef.app.repository.Repository
import javax.inject.Inject

@HiltViewModel
class NumberScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    suspend fun getNumbersData(): DataOrException<Numbers, Boolean, Exception> {
        return repository.getNumbers()
    }
}