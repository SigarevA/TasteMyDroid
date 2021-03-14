package hackathon.tastemydroid.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "days")
@Parcelize
data class Day(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
) : Parcelable