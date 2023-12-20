package com.example.consumeapi.data

import com.example.consumeapi.model.Kontak
import com.example.consumeapi.network.KontakService

interface KontakRepository {
    /** Fetches list of Kontak from kontakApi */
    suspend fun getKontak(): List<Kontak>
    suspend fun insertKontak(kontak: Kontak)
    suspend fun updateKontak(id: Int, kontak: Kontak)
    suspend fun deleteKontak(id: Int)
    suspend fun getKontakById(id: Int): Kontak


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

    // update kontak
    override suspend fun updateKontak(id: Int, kontak: Kontak) {
        kontakApiService.updateKontak(id, kontak)
    }

    // delete kontak
    override suspend fun deleteKontak(id: Int) {
        kontakApiService.deleteKontak(id)
    }

    override suspend fun getKontakById(id: Int): Kontak {
        return kontakApiService.getKontakById(id)
    }


}
