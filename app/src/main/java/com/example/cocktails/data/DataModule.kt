package com.example.cocktails.data

import androidx.room.Room
import com.example.cocktails.data.local.CocktailsDatabase
import com.example.cocktails.data.remote.CocktailRepository
import com.example.cocktails.data.remote.CocktailsApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single { val retrofit = Retrofit.Builder()
        .baseUrl("https://www.thecocktaildb.com/api/json/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        retrofit.create(CocktailsApi::class.java)
    }

    single { CocktailRepository(get()) }

    single { val cocktailDb = Room.databaseBuilder(
        get(),
        CocktailsDatabase::class.java,"cocktail database"
    ).build()

        cocktailDb.cocktailDao()
    }
}