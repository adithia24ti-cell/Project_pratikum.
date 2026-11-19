package com.example.adithia_3tie.Data.Api

import com.example.adithia_3tie.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}