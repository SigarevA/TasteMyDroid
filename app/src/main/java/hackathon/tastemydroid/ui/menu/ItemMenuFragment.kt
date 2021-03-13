package hackathon.tastemydroid.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentItemMenuBinding
import hackathon.tastemydroid.databinding.FragmentMenuContainerBinding


class ItemMenuFragment : Fragment() {
    private var _binding: FragmentItemMenuBinding? = null
    private val binding get() = _binding!!

       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemMenuBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.recipeListFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    companion object {
        @JvmStatic
        fun getInstance() =
            ItemMenuFragment()//.apply {
        //  arguments = Bundle().apply {
        //  }
    }
}
