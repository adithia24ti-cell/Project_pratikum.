package com.example.adithia_3tie.Data.Api

import com.example.adithia_3tie.Data.Model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}