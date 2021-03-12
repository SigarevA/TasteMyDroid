package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R
import hackathon.tastemydroid.ui.adapters.ProductsListAdapter

class ProductsListFragment : Fragment() {
    private var productsListRecyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products_list, container, false)

        initUI(view)

        return view
    }

    private fun initUI(view: View) {
        productsListRecyclerView = view.findViewById(R.id.products_list)
        productsListRecyclerView?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = ProductsListAdapter()
        }
    }

    companion object {
        fun createFragment() = ProductsListFragment()
    }
}