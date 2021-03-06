package hackathon.tastemydroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import hackathon.tastemydroid.entities.Ingredient

@Dao
interface IngredientDao {
    @Insert
    suspend fun addIngredient(ingredient: Ingredient)
}