package hackathon.tastemydroid.ui.cookingsteps

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hackathon.tastemydroid.databinding.ItemIngredientBinding
import hackathon.tastemydroid.databinding.ItemStepBinding
import hackathon.tastemydroid.entities.CookingStep


class CookingStepVH(private val binding : ItemStepBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cooking : CookingStep) {
        binding.itemStepNumber.text = cooking.number.toString()
        binding.itemStepDescribeStep.text = cooking.description
    }
}

class CookingStepAdapter(val steps : List<CookingStep>) : RecyclerView.Adapter<CookingStepVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookingStepVH {
        val binding =
            ItemStepBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CookingStepVH(binding)
    }

    override fun getItemCount(): Int = steps.size

    override fun onBindViewHolder(holder: CookingStepVH, position: Int) {
        val cookingStep = steps[position]
        holder.bind(cookingStep)
    }
}