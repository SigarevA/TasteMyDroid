package hackathon.tastemydroid.network.dto

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class StepResponse (
    val number : Int,
    val description : String
) : Parcelable