package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R

class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(context, COLUMNS)
    }

    companion object {
        private const val COLUMNS = 2
    }
}
