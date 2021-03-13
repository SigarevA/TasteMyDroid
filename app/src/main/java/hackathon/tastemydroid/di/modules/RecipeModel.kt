package hackathon.tastemydroid.di.modules

import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import hackathon.tastemydroid.di.scopes.Recipe
import hackathon.tastemydroid.repositories.RussianFoodRepo
import hackathon.tastemydroid.ui.fragments.RecipeListFragment
import hackathon.tastemydroid.ui.fragments.RecipeListVM
import hackathon.tastemydroid.ui.fragments.RecipeViewModelFactory

@Module
class RecipeModel {
    @Provides
    @Recipe
    fun provideFactory(russianFoodRepo: RussianFoodRepo) : RecipeViewModelFactory {
        return RecipeViewModelFactory(russianFoodRepo)
    }

  /*  @Provides
    @Recipe
    fun provideViewModel(fragment: RecipeListFragment, factory : RecipeViewModelFactory) : RecipeListVM {
        return ViewModelProvider(fragment, factory).get(RecipeListVM::class.java)
    }*/
}