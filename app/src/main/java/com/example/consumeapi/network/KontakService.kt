package com.example.consumeapi.network

import com.example.consumeapi.model.Kontak
import retrofit2.http.GET
import retrofit2.http.Headers

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak/getAllKontak")
    suspend fun getKontak(): List<Kontak>
}