package com.firdavs.impl.network

import com.firdavs.impl.network.model.ProductsDto
import retrofit2.http.GET

interface EcommerceApi {

    companion object {
        const val BASE_URL = "https://run.mocky.io/v3/"
    }

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getProducts(): ProductsDto
}