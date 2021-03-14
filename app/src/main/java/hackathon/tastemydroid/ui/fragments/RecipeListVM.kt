package hackathon.tastemydroid.ui.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hackathon.tastemydroid.network.dto.RecipeResponse
import hackathon.tastemydroid.repositories.RussianFoodRepo
import kotlinx.coroutines.launch

class RecipeListVM(private val russianFoodRepo: RussianFoodRepo) : ViewModel() {

    init {
        exRecipes()
    }

    private val recipesMutableLiveData = MutableLiveData<List<RecipeResponse>>()

    fun getRecipes() : LiveData<List<RecipeResponse>> = recipesMutableLiveData

    private fun exRecipes() {
        viewModelScope.launch {
            val recipes = russianFoodRepo.getRecipes()
            Log.d("FGF", recipes.toString())
            recipesMutableLiveData.value = recipes
        }
    }
}