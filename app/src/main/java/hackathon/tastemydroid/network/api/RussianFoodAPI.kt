package hackathon.tastemydroid.network.api

import hackathon.tastemydroid.network.dto.RecipeResponse
import retrofit2.http.GET

interface RussianFoodAPI {
    @GET("russianfood")
    suspend fun getRecipes() : List<RecipeResponse>
}