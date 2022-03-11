package org.yosef.giniapp.screens.numbers

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.yosef.giniapp.data.DataOrException
import org.yosef.giniapp.models.Numbers
import org.yosef.giniapp.repository.Repository
import javax.inject.Inject

@HiltViewModel
class NumberScreenViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    suspend fun getNumbersData(): DataOrException<Numbers, Boolean, Exception> {
        return repository.getNumbers()
    }
}