package com.example.cocktails.data.remote


class CocktailRepository(private val cocktailsApi: CocktailsApi) {

    suspend fun getRandomCocktail() = cocktailsApi.getRandomCocktail()
}