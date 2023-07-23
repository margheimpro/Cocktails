package com.example.cocktails.ui.homeScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cocktails.data.remote.CocktailRemote
import com.example.cocktails.data.remote.CocktailRepository

import kotlinx.coroutines.launch

class HomeScreenViewModel(private val cocktailRepository: CocktailRepository) : ViewModel() {


    private val _cocktailsLiveData = MutableLiveData<CocktailRemote>()
    val cocktailLiveData: LiveData<CocktailRemote> = _cocktailsLiveData

    fun getRandomCocktail(){
        viewModelScope.launch {
            try {
                val cocktail = cocktailRepository.getRandomCocktail()
                _cocktailsLiveData.postValue(cocktail)
            } catch (e: Exception){
                Log.e("HomeScreenViewModel","lack of connection")
            }
        }
    }
}