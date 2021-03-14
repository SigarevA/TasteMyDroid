package hackathon.tastemydroid.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import hackathon.tastemydroid.db.MenuDataBase
import hackathon.tastemydroid.db.dao.DayDao
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideMenuDataBase(context: Context) : MenuDataBase =
        MenuDataBase.getInstance(context)

    @Singleton
    @Provides
    fun provideDayDao(menuDataBase: MenuDataBase) : DayDao =
        menuDataBase.dayDao()
}