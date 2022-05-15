package org.yosef.app.repository

import org.yosef.app.data.DataOrException
import org.yosef.app.models.Numbers
import org.yosef.app.network.NumbersApi
import javax.inject.Inject

class Repository @Inject constructor(private val api: NumbersApi) {

    private val dataOrException = DataOrException<Numbers, Boolean, Exception>()

    suspend fun getNumbers(): DataOrException<Numbers, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getNumbers()
        } catch (e: Exception) {
            dataOrException.e = e
        }
        dataOrException.loading = false
        return dataOrException
    }
}