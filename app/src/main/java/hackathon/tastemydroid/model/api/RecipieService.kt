package hackathon.tastemydroid.model.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RecipieService {
    @GET("random.php")
    suspend fun getRandomRecipe(): Meals
}