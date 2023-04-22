package edu.udb.appcoroutinedog

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DogApiClient {
    private val dogApiService: DogApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        dogApiService = retrofit.create(DogApiService::class.java)
    }

    suspend fun getRandomDogImage(): String {
        val response = dogApiService.getRandomDogImage()
        return response.imageUrl
    }
}
