package hackathon.tastemydroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hackathon.tastemydroid.entities.DayEntity
import hackathon.tastemydroid.entities.MenuEntity
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.Recipe

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu")
    suspend fun getAllMenu(): List<MenuEntity>

    @Query("SELECT * FROM menu WHERE timestamp = :timestamp")
    suspend fun getMenuByTimestamp(timestamp: Int): MenuEntity

    @Insert
    suspend fun addMenu(menu: MenuEntity)
}
