package hackathon.tastemydroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import hackathon.tastemydroid.R
import hackathon.tastemydroid.ui.cookingsteps.CookingStepsFragment
import hackathon.tastemydroid.ui.ingredients.IngredientsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}