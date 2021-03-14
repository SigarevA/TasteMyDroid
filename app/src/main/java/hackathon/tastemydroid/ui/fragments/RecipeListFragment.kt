package hackathon.tastemydroid.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import hackathon.tastemydroid.HomeApplication
import hackathon.tastemydroid.R
import hackathon.tastemydroid.databinding.FragmentRecipeListBinding
import hackathon.tastemydroid.di.components.RecipeComponent
import hackathon.tastemydroid.ui.adapters.RecipeListAdapter
import hackathon.tastemydroid.ui.detailrecipe.DetailRecipeFragment
import javax.inject.Inject

class RecipeListFragment : Fragment() {

    private var _binding: FragmentRecipeListBinding? = null
    private val binding get() = _binding!!
    private var component: RecipeComponent? = null

    @Inject
    lateinit var factory: RecipeViewModelFactory

    private lateinit var vm: RecipeListVM

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val factory =
            (requireActivity().application as HomeApplication).appComponent.registrateRecipeComponent()
        component = factory.create()
        component!!.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this, factory).get(RecipeListVM::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.getRecipes().observe(viewLifecycleOwner, Observer {
            Log.d("tag", "next")
            binding.recycler.adapter = RecipeListAdapter(it) {
                findNavController().navigate(
                    R.id.action_recipeListFragment_to_detailRecipeFragment,
                    DetailRecipeFragment.getBundle(it)
                )
            }
        })
        binding.toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.recycler.adapter = null
        _binding = null
    }

    override fun onDetach() {
        super.onDetach()
        component = null
    }

    companion object {
    }
}
