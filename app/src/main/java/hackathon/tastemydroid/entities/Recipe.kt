package hackathon.tastemydroid.entities

import androidx.room.*
import hackathon.tastemydroid.db.ConverterCookingSteps
import hackathon.tastemydroid.db.ConverterIngredient
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "Recipes")
class Recipe(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "ingredients")
    @TypeConverters(ConverterCookingSteps::class)
    val ingredients: List<Ingredient>,

    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,

    @ColumnInfo(name = "cookingSteps")
    @TypeConverters(ConverterCookingSteps::class)
    val cookingSteps: List<CookingStep>
)
