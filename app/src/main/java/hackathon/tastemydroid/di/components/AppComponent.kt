package hackathon.tastemydroid.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import hackathon.tastemydroid.di.modules.ApiModule
import hackathon.tastemydroid.di.modules.AppSubcomponents
import hackathon.tastemydroid.di.modules.NetworkModule
import hackathon.tastemydroid.di.modules.RepoModule
import hackathon.tastemydroid.ui.fragments.RecipeListFragment
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, AppSubcomponents::class, RepoModule::class, ApiModule::class])
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context : Context) : AppComponent
    }
    fun registrateRecipeComponent() : RecipeComponent.Factory
}