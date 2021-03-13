package hackathon.tastemydroid.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Menu")
class MenuEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: String,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long
) {
}
