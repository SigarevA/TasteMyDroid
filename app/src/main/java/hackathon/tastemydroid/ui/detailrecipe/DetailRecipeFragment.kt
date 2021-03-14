package hackathon.tastemydroid.ui.detailrecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragDetailRecipeBinding
import hackathon.tastemydroid.network.dto.RecipeResponse
import hackathon.tastemydroid.ui.ingredients.IngredientsFragment
import hackathon.tastemydroid.ui.cookingsteps.CookingStepsFragment
import java.lang.IllegalArgumentException

private const val RECIPE_KEY = "recipe"

class DetailRecipeFragment : Fragment() {

    private var _binding: FragDetailRecipeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recipeResponse : RecipeResponse

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragDetailRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fragDetailRecipePager.adapter = DemoCollectionAdapter(this)
        TabLayoutMediator(binding.tabs, binding.fragDetailRecipePager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.frag_detail_ingredients)
                1 -> resources.getString(R.string.frag_detail_сooking_instructions)
                else -> throw IllegalAccessException("Ha-ha, nubs2!")
            }
          }.attach()
        arguments?.let {
            recipeResponse = it.getParcelable(RECIPE_KEY)!!
        } ?: throw IllegalArgumentException("Ha, see you)")
        Glide.with(requireContext())
            .load("http:${recipeResponse.imagePath}")
            .into(binding.fragDetailRecipeIv)
        setupToolbar()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupToolbar() {
        binding.toolbar.title = recipeResponse.name
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    inner class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> IngredientsFragment.getInstance(recipeResponse.ingredients.toTypedArray())
            1 -> CookingStepsFragment.getInstance(recipeResponse.steps.toTypedArray())
            else -> throw IllegalAccessException("Ha-ha, nubs!")
        }
    }

    companion object{
        fun getBundle(recipeResponse: RecipeResponse) : Bundle = Bundle()
            .apply {
                putParcelable(RECIPE_KEY, recipeResponse)
            }
    }
}