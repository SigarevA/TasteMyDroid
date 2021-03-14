package hackathon.tastemydroid.ui.ingredients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.databinding.ItemIngredientBinding
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.network.dto.IngredientResponse

class IngredientVH(private val binding: ItemIngredientBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(ingredient: IngredientResponse) {
        binding.itemIngredientName.text = ingredient.name
        binding.itemIngredientSize.text = ingredient.count
    }
}

class IngredientsAdapter(private val ingredients: List<IngredientResponse>) :
    RecyclerView.Adapter<IngredientVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientVH {
        val binding =
            ItemIngredientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return IngredientVH(binding)
    }

    override fun getItemCount(): Int = ingredients.size

    override fun onBindViewHolder(holder: IngredientVH, position: Int) {
        val ingredient = ingredients[position]
        holder.bind(ingredient)
    }
}