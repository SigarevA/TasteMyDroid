package hackathon.tastemydroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import hackathon.tastemydroid.entities.Menu

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu")
    suspend fun getAllMenu(): List<Menu>

    @Query("SELECT * FROM menu WHERE creation_data = :timestamp")
    suspend fun getMenuByTimestamp(timestamp: Long): Menu

    @Insert
    suspend fun addMenu(menu: Menu)
}
