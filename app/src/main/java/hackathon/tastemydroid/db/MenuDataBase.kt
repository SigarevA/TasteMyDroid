package hackathon.tastemydroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Insert
import androidx.room.Room
import androidx.room.RoomDatabase
import hackathon.tastemydroid.entities.DayEntity
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.MenuEntity
import hackathon.tastemydroid.entities.Recipe

@Database(
    entities = [MenuEntity::class, Recipe::class, Ingredient::class, DayEntity::class],
    version = 1
)
abstract class MenuDataBase : RoomDatabase() {
    abstract val menuDao: MenuDataBase
    abstract val ingredientDao: MenuDataBase
    abstract val recipeDao: MenuDataBase
    abstract val dayDao: MenuDataBase

    companion object {
        private var INSTANCE: MenuDataBase? = null
        fun create(applicationContext: Context): MenuDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    applicationContext,
                    MenuDataBase::class.java,
                    "MenuDataBase.db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    suspend fun getAllRecipes(): List<Recipe> = recipeDao.getAllRecipes()

    suspend fun addRecipe(recipe: Recipe) {
        recipeDao.addRecipe(recipe)
    }

    suspend fun addIngredient(ingredient: Ingredient) {
        ingredientDao.addIngredient(ingredient)
    }

    suspend fun addDay(dayEntity: DayEntity) {
        dayDao.addDay(dayEntity)
    }

    suspend fun getAllMenu(): List<MenuEntity> = menuDao.getAllMenu()

    suspend fun getMenuByTimestamp(timestamp: Int): MenuEntity =
        menuDao.getMenuByTimestamp(timestamp)

    suspend fun addMenu(menu: MenuEntity) {
        menuDao.addMenu(menu)
    }
}
