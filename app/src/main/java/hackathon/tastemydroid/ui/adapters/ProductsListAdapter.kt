package hackathon.tastemydroid.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.ProductItemBinding
import hackathon.tastemydroid.entities.Ingredient


class ProductsListAdapter(private val productsList: List<Ingredient>) : RecyclerView.Adapter<ProductsListAdapter.ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val productBinding = ProductItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(productBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(productsList[position])
    }

    override fun getItemCount(): Int = productsList.size

    inner class ProductViewHolder(
        private val productBinding: ProductItemBinding
    ) : RecyclerView.ViewHolder(productBinding.root) {
        fun onBind(ingredient: Ingredient) {
            setProductName(ingredient)
            setProductTotal(ingredient)
        }

        private fun setProductName(ingredient: Ingredient) {
            productBinding.tvProductName.text = ingredient.name
        }

        private fun setProductTotal(ingredient: Ingredient) {
            productBinding.tvProductTotal.text = ingredient.count
        }
    }
}
