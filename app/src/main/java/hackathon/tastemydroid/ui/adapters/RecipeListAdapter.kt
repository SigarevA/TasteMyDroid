package hackathon.tastemydroid.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.ViewHolderRecipeBinding
import hackathon.tastemydroid.entities.Recipe

class RecipeListAdapter(
    private val listener: (Int) -> Unit
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    val recipes = mutableListOf<Recipe>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_recipe, parent, false)
        return RecipeViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(recipes[position])


    override fun getItemCount(): Int = recipes.size

    class RecipeViewHolder(view: View, private val clickListener: (Int) -> Unit): RecyclerView.ViewHolder(view) {
       private val binding = ViewHolderRecipeBinding.bind(itemView)

        fun bind(recipe: Recipe) {
            Glide
                .with(itemView)
                .load(recipe.imageUrl)
                .into(binding.picture)

            binding.name.text = recipe.name
        }
    }
}
