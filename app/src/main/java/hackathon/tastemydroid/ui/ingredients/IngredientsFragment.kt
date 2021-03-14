package hackathon.tastemydroid.ui.ingredients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragDetailRecipeBinding
import hackathon.tastemydroid.databinding.FragmentIngredientsBinding
import hackathon.tastemydroid.entities.Ingredient
import hackathon.tastemydroid.network.dto.IngredientResponse
import java.lang.IllegalArgumentException

private const val PARAM_ARG_INGREDIENTS = "INGREDIENTS"

class IngredientsFragment : Fragment() {

    private var _binding: FragmentIngredientsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIngredientsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ingredients : List<IngredientResponse> = arguments?.let {
            it.getParcelableArray(PARAM_ARG_INGREDIENTS)!!.toList() as List<IngredientResponse>
        } ?: throw IllegalArgumentException("Ha-ha, again see you!")
        val adapter = IngredientsAdapter(ingredients)
        binding.fragIngredientsRv.adapter = adapter
    }

    companion object{
        fun getInstance( ingredients : Array<IngredientResponse>) : IngredientsFragment {
            return IngredientsFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArray(PARAM_ARG_INGREDIENTS, ingredients)
                }
            }
        }
    }
}