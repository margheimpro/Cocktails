package com.example.cocktails.data.remote

import retrofit2.http.GET

interface CocktailsApi {
    @GET("1/random.php")
    suspend fun getRandomCocktail(): CocktailRemote
}