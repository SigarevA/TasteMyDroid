package hackathon.tastemydroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hackathon.tastemydroid.entities.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes")
    suspend fun getAllRecipes(): List<Recipe>

    @Insert
    suspend fun addRecipe(recipe: Recipe)
}