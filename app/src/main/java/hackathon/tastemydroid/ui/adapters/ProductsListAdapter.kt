package hackathon.tastemydroid.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R

// TODO replace RecyclerViewAdapter with ListAdapter after creating Product POJO
class ProductsListAdapter : RecyclerView.Adapter<ProductsListAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind() // TODO set item by position
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind() {
            setProductName()
            setProductTotal()
        }

        private fun setProductName() {
            TODO("Not yet implemented")
        }

        private fun setProductTotal() {
            TODO("Not yet implemented")
        }
    }
}