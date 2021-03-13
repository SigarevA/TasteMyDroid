package hackathon.tastemydroid.ui.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentMenuContainerBinding


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
            0 -> ItemMenuFragment.getInstance()
            1 -> ItemMenuFragment.getInstance()
            2 -> ItemMenuFragment.getInstance()
            3 -> ItemMenuFragment.getInstance()
            4 -> ItemMenuFragment.getInstance()
            5 -> ItemMenuFragment.getInstance()
            6 -> ItemMenuFragment.getInstance()
            else ->  throw IllegalAccessException("ops!")
        }
    }
}