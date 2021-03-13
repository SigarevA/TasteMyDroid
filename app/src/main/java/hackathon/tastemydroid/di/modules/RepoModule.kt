package hackathon.tastemydroid.di.modules

import dagger.Binds
import dagger.Module
import hackathon.tastemydroid.repositories.RussianFoodRepo
import hackathon.tastemydroid.repositories.RussianFoodRepoImpl

@Module
abstract class RepoModule {
    @Binds
    abstract fun bind(russianFoodRepo: RussianFoodRepoImpl) : RussianFoodRepo
}