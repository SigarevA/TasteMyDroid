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
        val ingredients = listOf(
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка"),
            Ingredient("Куриное филе", "600 г"),
            Ingredient("Сметана", "2 ст. ложки"),
            Ingredient("Томатная паста ", "1 ст. ложка")
        )
        val adapter = IngredientsAdapter(ingredients)
        binding.fragIngredientsRv.adapter = adapter
    }
}