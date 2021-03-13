package hackathon.tastemydroid.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hackathon.tastemydroid.entities.Recipe

@Dao
interface MenuDao {
    @Query("SELECT * FROM Recipes ")
    suspend fun getAllRecipes(): List<Recipe>
}
