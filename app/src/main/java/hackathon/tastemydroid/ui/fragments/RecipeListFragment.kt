package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentProductsListBinding
import hackathon.tastemydroid.databinding.FragmentRecipeListBinding
import hackathon.tastemydroid.entities.Recipe
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter
import hackathon.tastemydroid.ui.adapters.RecipeListAdapter

class RecipeListFragment : Fragment() {

    private var _binding: FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  =  FragmentRecipeListBinding.inflate(inflater, container, false)
        setupToolbar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        // TODO SET RECIPIES FROM FIREBASE HERE
        binding.recycler.adapter = RecipeListAdapter(emptyList(), ::onRecipeAdded)
    }

    private fun onRecipeAdded(recipe: Recipe) {
        // TODO ADD RECIPE TO SELECTED DAY
    }

    private fun setupToolbar() {
        binding.toolbar.toolbar.title = getString(R.string.menu_select_recipe)
        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
    }
}
