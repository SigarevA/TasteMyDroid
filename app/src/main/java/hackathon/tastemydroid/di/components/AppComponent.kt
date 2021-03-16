package hackathon.tastemydroid.di.components

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import hackathon.tastemydroid.di.modules.*
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        AppSubcomponents::class,
        RepoModule::class,
        ApiModule::class,
        DataBaseModule::class
    ]
)
@Singleton
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
    fun registrateRecipeComponent(): RecipeComponent.Factory
}