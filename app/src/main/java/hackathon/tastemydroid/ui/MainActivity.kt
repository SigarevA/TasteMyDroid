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
        /*val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.act_main_container, DetailRecipeFragment(), "Detail")
        transaction.commitNow()*/
        /*val pager = findViewById<ViewPager2>(R.id.frag_detail_recipe_pager)
        pager.adapter = DemoCollectionAdapter(this)*/
    }


    class DemoCollectionAdapter(activity: MainActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> IngredientsFragment()
                1 -> CookingStepsFragment()
                else -> throw IllegalAccessException("Ha-ha, nubs!")
            }
        }
    }
}