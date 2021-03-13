package hackathon.tastemydroid.utils

import hackathon.tastemydroid.entities.CookingStep
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.Recipe
import hackathon.tastemydroid.model.api.Meals
import hackathon.tastemydroid.model.api.MealsItem

class RecipeConverter {
    companion object {
        fun convertRecipeToEntity(recipeFromApi: Meals): Recipe {
            val item = recipeFromApi.meals?.get(0)
            return Recipe(
                imageUrl = item?.strMealThumb!!,
                name = item.strMeal!!,
                manualSteps = getCookingStep(item.strInstructions!!),
                id = item.idMeal?.toInt()!!,
                ingredients = getIngredients(item)
            )
        }

        private fun getCookingStep(instruction: String): List<CookingStep> {
            val list = instruction.split("\r\n")
            val steps = mutableListOf<CookingStep>()
            for ((number, step) in list.withIndex()) {
                steps.add(
                    CookingStep(number + 1, step)
                )
            }
            return steps
        }

        private fun getIngredients(item: MealsItem): List<Ingredient> {
            val ingredientListFromItem = listOf(
                item.strIngredient1,
                item.strIngredient2,
                item.strIngredient3,
                item.strIngredient4,
                item.strIngredient5,
                item.strIngredient6,
                item.strIngredient7,
                item.strIngredient8,
                item.strIngredient9,
                item.strIngredient10,
                item.strIngredient11,
                item.strIngredient12,
                item.strIngredient13,
                item.strIngredient14,
                item.strIngredient15,
                item.strIngredient16,
                item.strIngredient17,
                item.strIngredient18,
                item.strIngredient19,
                item.strIngredient20
            )
            val measureListFromItem = listOf(
                item.strMeasure1,
                item.strMeasure2,
                item.strMeasure3,
                item.strMeasure4,
                item.strMeasure5,
                item.strMeasure6,
                item.strMeasure7,
                item.strMeasure8,
                item.strMeasure9,
                item.strMeasure10,
                item.strMeasure11,
                item.strMeasure12,
                item.strMeasure13,
                item.strMeasure14,
                item.strMeasure15,
                item.strMeasure16,
                item.strMeasure17,
                item.strMeasure18,
                item.strMeasure19,
                item.strMeasure20
            )
            val list = mutableListOf<Ingredient>()
            for ((index, ingredientItem) in ingredientListFromItem.withIndex()) {
                if (ingredientItem != null) {
                    list.add(Ingredient(ingredientItem, measureListFromItem.get(index)!!))
                }
            }
            return list
        }
    }
}