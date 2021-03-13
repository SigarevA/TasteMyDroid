package hackathon.tastemydroid.db

import android.content.Context
import hackathon.tastemydroid.entities.DayEntity
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.MenuEntity
import hackathon.tastemydroid.entities.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MenuRepository(context: Context) {
    private val menuDataBase: MenuDataBase by lazy { MenuDataBase.create(context) }

    suspend fun initDays() {
        withContext(Dispatchers.IO) {
            addDay(DayEntity(null, MONDAY))
            addDay(DayEntity(null, TUESDAY))
            addDay(DayEntity(null, WEDNESDAY))
            addDay(DayEntity(null, THURSDAY))
            addDay(DayEntity(null, FRIDAY))
            addDay(DayEntity(null, SATURDAY))
            addDay(DayEntity(null, SUNDAY))
        }
    }

    suspend fun getAllRecipes(): List<Recipe> = menuDataBase.getAllRecipes()

    suspend fun addRecipe(recipe: Recipe) {
        menuDataBase.addRecipe(recipe)
    }

    suspend fun addIngredient(ingredient: Ingredient) {
        menuDataBase.addIngredient(ingredient)
    }

    private suspend fun addDay(dayEntity: DayEntity) {
        withContext(Dispatchers.IO) {
            menuDataBase.addDay(dayEntity)
        }
    }

    suspend fun getAllMenu(): List<MenuEntity> = menuDataBase.getAllMenu()

    suspend fun getMenuByTimestamp(timestamp: Int): MenuEntity =
        menuDataBase.getMenuByTimestamp(timestamp)

    suspend fun addMenu(menu: MenuEntity) {
        menuDataBase.addMenu(menu)
    }

    companion object {
        private const val MONDAY = "Понедельник"
        private const val TUESDAY = "Вторник"
        private const val WEDNESDAY = "Среда"
        private const val THURSDAY = "Четверг"
        private const val FRIDAY = "Пятница"
        private const val SATURDAY = "Суббота"
        private const val SUNDAY = "Воскресенье"
    }
}