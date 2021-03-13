package hackathon.tastemydroid.repositories

import hackathon.tastemydroid.network.dto.RecipeResponse

interface RussianFoodRepo {
    suspend fun getRecipes() : List<RecipeResponse>
}