package hackathon.tastemydroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.ActivityMainBinding
import hackathon.tastemydroid.ui.cookingsteps.CookingStepsFragment
import hackathon.tastemydroid.ui.ingredients.IngredientsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}