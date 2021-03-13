package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentProductsListBinding
import hackathon.tastemydroid.databinding.FragmentRecipeListBinding
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter
import hackathon.tastemydroid.ui.adapters.RecipeListAdapter

class RecipeListFragment : Fragment(R.layout.fragment_recipe_list) {

    private var _binding: FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        binding.recycler.adapter = RecipeListAdapter(TODO("add listener"))
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
    }
}
