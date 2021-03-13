package hackathon.tastemydroid

import android.app.Application
import hackathon.tastemydroid.di.components.AppComponent
import hackathon.tastemydroid.di.components.DaggerAppComponent

class HomeApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}