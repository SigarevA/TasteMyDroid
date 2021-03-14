package hackathon.tastemydroid.entities

import kotlinx.serialization.Serializable

@Serializable
data class CookingStep (
    val number : Int,
    val description : String
)
