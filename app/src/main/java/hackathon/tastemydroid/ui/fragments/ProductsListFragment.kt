package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentProductsListBinding
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter
import kotlinx.android.synthetic.main.fragment_products_list.view.*

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