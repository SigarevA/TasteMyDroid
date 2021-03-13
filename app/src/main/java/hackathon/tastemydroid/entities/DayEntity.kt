package hackathon.tastemydroid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable


@Entity(tableName = "days")
class DayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String
)