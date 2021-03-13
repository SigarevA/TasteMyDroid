package hackathon.tastemydroid.db

import androidx.room.TypeConverter
import hackathon.tastemydroid.entities.CookingStep
import hackathon.tastemydroid.entities.Ingredient
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ConverterIngredient {
    @TypeConverter
    fun fromIngredient(ingredients: List<Ingredient?>): String? {
        return Json.encodeToString(ingredients)
    }

    @TypeConverter
    fun toIngredient(data: String): List<Ingredient?>? {
        return Json.decodeFromString(data)
    }
}

class ConverterCookingSteps {
    @TypeConverter
    fun fromSteps(steps: List<CookingStep?>): String? {
        return Json.encodeToString(steps)
    }

    @TypeConverter
    fun toSteps(data: String): List<CookingStep?>? {
        return Json.decodeFromString(data)
    }
}
