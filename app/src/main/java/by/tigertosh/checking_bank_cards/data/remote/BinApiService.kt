package by.tigertosh.checking_bank_cards.data.remote

import by.tigertosh.checking_bank_cards.domain.model.BinResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface BinApiService {
    @Headers("Accept-Version: 3")
    @GET("{bin}")
    suspend fun getBinDetails(@Path("bin") bin: String): Response<BinResponse>
}