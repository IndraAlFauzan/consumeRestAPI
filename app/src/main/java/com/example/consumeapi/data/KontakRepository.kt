package com.example.consumeapi.data

import com.example.consumeapi.model.Kontak
import com.example.consumeapi.network.KontakService

interface KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>
    suspend fun insertKontak(kontak: Kontak)


}

class NetworkKontakRepository(
    private val kontakApiService: KontakService
) : KontakRepository {
    /** Fetches list of Kontak from kontakApi*/
    override suspend fun getKontak(): List<Kontak> = kontakApiService.getKontak()
    // insert kontak
    override suspend fun insertKontak(kontak: Kontak) {
        kontakApiService.insertKontak(kontak)
    }


}
