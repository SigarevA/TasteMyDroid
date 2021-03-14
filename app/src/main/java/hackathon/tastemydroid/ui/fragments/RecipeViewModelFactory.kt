package hackathon.tastemydroid.ui.fragments

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import hackathon.tastemydroid.repositories.RussianFoodRepo

class RecipeViewModelFactory(val russianFoodRepo: RussianFoodRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecipeListVM::class.java)) {
            return RecipeListVM(russianFoodRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}