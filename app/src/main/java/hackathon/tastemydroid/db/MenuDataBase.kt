package hackathon.tastemydroid.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.entities.Recipe

@Database(entities = [MenuEntity::class, Recipe::class, Ingredient::class], version = 1)
abstract class MenuDataBase: RoomDatabase() {

    abstract val moviesDao: MenuDataBase

    companion object {

        fun create(applicationContext: Context): MenuDataBase = Room.databaseBuilder(
            applicationContext,
            MenuDataBase::class.java,
            "MenuDataBase.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
