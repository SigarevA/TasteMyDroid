package hackathon.tastemydroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackathon.tastemydroid.db.dao.DayDao
import hackathon.tastemydroid.db.dao.IngredientDao
import hackathon.tastemydroid.db.dao.MenuDao
import hackathon.tastemydroid.db.dao.RecipeDao
import hackathon.tastemydroid.entities.Day
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.Menu
import hackathon.tastemydroid.entities.Recipe

@Database(
    entities = [Menu::class, Recipe::class, Ingredient::class, Day::class],
    version = 1
)
abstract class MenuDataBase : RoomDatabase() {
    abstract fun menuDao(): MenuDao
    abstract fun ingredientDao(): IngredientDao
    abstract fun recipeDao(): RecipeDao
    abstract fun dayDao(): DayDao

    companion object {
        @Volatile
        private var INSTANCE: MenuDataBase? = null

        fun getInstance(applicationContext: Context): MenuDataBase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    applicationContext,
                    MenuDataBase::class.java,
                    "MenuDataBase"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}