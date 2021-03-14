package hackathon.tastemydroid.network.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class IngredientResponse (
    val name : String,
    val count : String
) : Parcelable