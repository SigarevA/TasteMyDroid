package hackathon.tastemydroid.network.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RecipeResponse(
    val name: String,
    val steps: List<StepResponse>,
    val ingredients: List<IngredientResponse>,
    val imagePath: String
) : Parcelable