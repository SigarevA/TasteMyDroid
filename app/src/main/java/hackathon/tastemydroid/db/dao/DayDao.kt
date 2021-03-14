package hackathon.tastemydroid.db.dao

import androidx.room.Dao
import androidx.room.Insert
import hackathon.tastemydroid.entities.Day

@Dao
interface DayDao {
    @Insert
    suspend fun addDay(dayEntity: Day)
}