package hackathon.tastemydroid.repositories

import hackathon.tastemydroid.network.api.RussianFoodAPI
import hackathon.tastemydroid.network.dto.RecipeResponse
import javax.inject.Inject

class RussianFoodRepoImpl @Inject constructor( val russianFoodAPI: RussianFoodAPI) : RussianFoodRepo {
    override suspend fun getRecipes(): List<RecipeResponse> =  russianFoodAPI.getRecipes()
}