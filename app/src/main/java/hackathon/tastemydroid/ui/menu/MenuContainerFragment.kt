package hackathon.tastemydroid.ui.menu

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentMenuContainerBinding
import hackathon.tastemydroid.ui.MainActivity


class MenuContainerFragment : Fragment() {

    private var _binding: FragmentMenuContainerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuContainerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        binding.viewpager.adapter = DaysCollectionAdapter(this)
        TabLayoutMediator(binding.tabs, binding.viewpager) { tab, position ->
            tab.text = when(position) {
                0 -> "Понедельник"
                1 -> "Вторник"
                2 -> "Среда"
                3 -> "Четверг"
                4 -> "Пятница"
                5 -> "Суббота"
                6 -> "Воскресенье"
                else ->  throw IllegalAccessException("ops!")
            }
        }.attach()

        (requireActivity() as MainActivity).setAddingRecipeListener(
            object: AddingRecipeListener {
                override fun add(dayId: Int) {
                    findNavController().navigate(R.id.action_menuContainerFragment_to_recipeListFragment)
                    //Toast.makeText(requireContext(), "day : $dayId", Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupToolbar() {
        binding.toolbar.title = getString(R.string.recipes_title) // TODO take from recipie (fragment arguments)
    }

    class DaysCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
        override fun getItemCount(): Int = 7

        override fun createFragment(position: Int): Fragment = when(position) {
            in 0..6 -> ItemMenuFragment.getInstance(position)
            else ->  throw IllegalAccessException("ops!")
        }
    }

    interface AddingRecipeListener {
        fun add(dayId : Int)
    }
}