package com.example.cocktails.ui.homeScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.cocktails.data.remote.CocktailRemote
import com.example.cocktails.data.remote.Drinks
import com.example.cocktails.databinding.HomeScreenBinding
import org.koin.android.ext.android.inject

class HomeScreen : Fragment() {

    private lateinit var binding: HomeScreenBinding

    private val viewModel: HomeScreenViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {
            viewModel.getRandomCocktail()
        }

        viewModel.cocktailLiveData.observe(viewLifecycleOwner){
            getDrinkInfo(it)
        }
    }

    private fun getDrinkInfo(cocktail: CocktailRemote){
        binding.recipe.visibility = View.VISIBLE
        cocktail.drinks.map {
            assignValues(it)
        }
    }

    private fun assignValues(value: Drinks){
        binding.cocktailName.text = value.strDrink
        binding.alcoholic.text = value.strAlcoholic
        binding.recipeValue.text = value.strInstructionsIT
        binding.photo.load(value.strDrinkThumb)
    }
}