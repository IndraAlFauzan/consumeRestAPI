package com.example.consumeapi.network

import com.example.consumeapi.model.Kontak
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak/getAllKontak")
    suspend fun getKontak(): List<Kontak>

    @POST("kontak/insertKontak")
    suspend fun insertKontak(@Body kontak: Kontak)
}