package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hackathon.tastemydroid.databinding.FragmentProductsListBinding
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter

class ProductsListFragment : Fragment() {
    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductsListBinding.inflate(
            inflater,
            container,
            false
        )
        initUI()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initUI() {
        binding.productsListRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            // TODO change empty list
            adapter = ProductsListAdapter(emptyList())
        }
    }

    companion object {
        fun createFragment() = ProductsListFragment()
    }
}