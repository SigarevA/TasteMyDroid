package hackathon.tastemydroid.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.ActivityMainBinding
import hackathon.tastemydroid.setupWithNavController
import hackathon.tastemydroid.ui.menu.ItemMenuFragment
import hackathon.tastemydroid.ui.menu.MenuContainerFragment

class MainActivity : AppCompatActivity(), ItemMenuFragment.Listener {

    private lateinit var binding: ActivityMainBinding

    private var currentNavController: LiveData<NavController>? = null
    private var addingRecipeListener : MenuContainerFragment.AddingRecipeListener? = null

    fun setAddingRecipeListener(listener: MenuContainerFragment.AddingRecipeListener) {
        addingRecipeListener = listener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    private fun setupBottomNavigationBar() {
        val navGraphIds = listOf( R.navigation.menu, R.navigation.products)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_fragment,
            intent = intent
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    override fun clickFab(daysId: Int) {
        addingRecipeListener?.add(daysId)
    }
}