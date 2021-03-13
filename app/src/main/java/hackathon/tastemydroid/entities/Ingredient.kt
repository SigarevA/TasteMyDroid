package hackathon.tastemydroid.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import hackathon.tastemydroid.db.ConverterIngredient
import kotlinx.serialization.Serializable



@Serializable
@Entity(tableName = "Ingredients")
class Ingredient (
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name : String,

    @ColumnInfo(name = "count")
    val count : String
)
