package hackathon.tastemydroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.Recipe

@Dao
interface MenuDao {
    @Query("SELECT * FROM Recipes")
    suspend fun getAllRecipes(): List<Recipe>

    @Insert
    suspend fun addRecipe(recipe: Recipe)

    @Insert
    suspend fun addMenu(menu: MenuEntity)

    @Insert
    suspend fun addIngredient(ingredient: Ingredient)

}
