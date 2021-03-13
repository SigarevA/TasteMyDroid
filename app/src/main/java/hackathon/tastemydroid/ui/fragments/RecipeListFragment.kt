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
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter

class RecipeListFragment : Fragment() {

    private var _binding: FragmentRecipeListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  =  FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        // TODO change emptylist
        binding.recycler.adapter = ProductsListAdapter(emptyList())
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
    }
}
