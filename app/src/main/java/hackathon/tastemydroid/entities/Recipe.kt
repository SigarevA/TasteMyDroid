package hackathon.tastemydroid.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "recipes")
@Parcelize
data class Recipe(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val imageUrl: String,
) : Parcelable