package com.example.consumeapi.network

import com.example.consumeapi.model.Kontak
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.concurrent.Flow

interface KontakService {
    @Headers(
        "Accept: application/json"
    )
    @GET("kontak/getAllKontak")
    suspend fun getKontak(): List<Kontak>
    @GET ("kontak/getKontakById/{id}")
    suspend fun getKontakById(@Path("id") id: Int): Kontak

    @POST("kontak/insertKontak")
    suspend fun insertKontak(@Body kontak: Kontak)

    @POST("kontak/updateKontak/{id}")
    suspend fun updateKontak(@Path("id") id: Int, @Body kontak: Kontak)

    @POST("kontak/deleteKontak/{id}")
    suspend fun deleteKontak(@Path("id") id: Int)


}