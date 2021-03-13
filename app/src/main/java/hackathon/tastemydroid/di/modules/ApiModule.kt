package hackathon.tastemydroid.di.modules

import dagger.Module
import dagger.Provides
import hackathon.tastemydroid.network.api.RussianFoodAPI
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApiModule {
    @Singleton
    @Provides
    fun provideRussianFoodApi(retrofit : Retrofit) : RussianFoodAPI {
        return retrofit.create(RussianFoodAPI::class.java)
    }
}