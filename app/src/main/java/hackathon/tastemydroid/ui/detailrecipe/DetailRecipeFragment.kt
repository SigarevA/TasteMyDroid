package hackathon.tastemydroid.ui.detailrecipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragDetailRecipeBinding
import hackathon.tastemydroid.ui.ingredients.IngredientsFragment
import hackathon.tastemydroid.ui.cookingsteps.CookingStepsFragment

class DetailRecipeFragment : Fragment() {

    private var _binding: FragDetailRecipeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragDetailRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        binding.fragDetailRecipePager.adapter = DemoCollectionAdapter(this)
        Glide.with(requireContext())
            .load("https://img4.goodfon.ru/wallpaper/nbig/e/92/vtorye-bliuda-sosiska-kartofel-doski-tarelka-eda.jpg")
            .into(binding.fragDetailRecipeIv)
        TabLayoutMediator(binding.tabs, binding.fragDetailRecipePager) { tab, position ->
            tab.text = when (position) {
                0 -> resources.getString(R.string.frag_detail_ingredients)
                1 -> resources.getString(R.string.frag_detail_сooking_instructions)
                else -> throw IllegalAccessException("Ha-ha, nubs2!")
            }
          }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupToolbar() {
        binding.toolbar.toolbar.title = getString(R.string.recipe_name_default) // TODO take from recipie (fragment arguments)
        binding.toolbar.toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        binding.toolbar.toolbar.setNavigationOnClickListener {
            activity?.onBackPressed()
        }
    }

    class DemoCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment = when (position) {
            0 -> IngredientsFragment()
            1 -> CookingStepsFragment()
            else -> throw IllegalAccessException("Ha-ha, nubs!")
        }
    }
}