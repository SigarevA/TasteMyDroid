package hackathon.tastemydroid.network.dto

class RecipeResponse(
    val name: String,
    val steps: List<StepResponse>,
    val ingredients: List<IngredientResponse>,
    val imagePath: String
)