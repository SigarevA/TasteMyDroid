package hackathon.tastemydroid.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R

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
        productsListRecyclerView?.layoutManager = LinearLayoutManager(activity)
    }

    companion object {
        fun createFragment() = ProductsListFragment()
    }
}