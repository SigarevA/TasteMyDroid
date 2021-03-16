package hackathon.tastemydroid.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.ViewHolderRecipeBinding
import hackathon.tastemydroid.network.dto.RecipeResponse

class RecipeListAdapter(
    private val recipes : List<RecipeResponse>,
    private val listener: (RecipeResponse) -> Unit
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_recipe, parent, false)
        return RecipeViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(recipes[position])

    override fun getItemCount(): Int = recipes.size

    class RecipeViewHolder(view: View, private val clickListener: (RecipeResponse) -> Unit): RecyclerView.ViewHolder(view) {
       private val binding = ViewHolderRecipeBinding.bind(itemView)

        fun bind(recipe: RecipeResponse) {
            Glide
                .with(itemView)
                .load("http:${recipe.imagePath}")
                .into(binding.picture)
            binding.name.text = recipe.name
            binding.root.setOnClickListener { clickListener(recipe) }
        }
    }
}