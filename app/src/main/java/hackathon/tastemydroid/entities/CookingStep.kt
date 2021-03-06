package hackathon.tastemydroid.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "cooking_step")
@Parcelize
data class CookingStep (
    @PrimaryKey(autoGenerate = true)
    val id : Long? = null,
    val number : Int,
    val description : String,
    val recipeId: Int
) : Parcelable