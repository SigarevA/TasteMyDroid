package hackathon.tastemydroid.entities

class Recipe(
    val id: Int,
    val name: String,
    val ingredients: List<Ingredient>,
    val imageUrl: String,
    val manualSteps: List<CookingStep>
)
