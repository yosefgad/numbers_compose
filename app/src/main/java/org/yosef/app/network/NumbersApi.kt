package org.yosef.app.network

import org.yosef.app.models.Numbers
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface NumbersApi {
    @GET("raw/8wJzytQX")
    suspend fun getNumbers(): Numbers
}