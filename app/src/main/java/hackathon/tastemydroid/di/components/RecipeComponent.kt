package hackathon.tastemydroid.di.components

import dagger.Subcomponent
import hackathon.tastemydroid.di.modules.RecipeModel
import hackathon.tastemydroid.di.scopes.Recipe
import hackathon.tastemydroid.ui.fragments.RecipeListFragment

@Subcomponent(modules = [RecipeModel::class])
@Recipe
interface RecipeComponent{
    @Subcomponent.Factory
    interface Factory{
        fun create() : RecipeComponent
    }
    fun inject( recipeListFragment : RecipeListFragment) : RecipeListFragment
}