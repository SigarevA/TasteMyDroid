package hackathon.tastemydroid.ui.cookingsteps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hackathon.tastemydroid.databinding.FragCookingStepsBinding
import hackathon.tastemydroid.entities.CookingStep
import hackathon.tastemydroid.network.dto.StepResponse
import java.util.*
import java.util.stream.Collectors

private const val ARG_PARAM = "steps"

class CookingStepsFragment : Fragment() {

    private var _binding: FragCookingStepsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragCookingStepsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val steps : List<StepResponse> = requireArguments().getParcelableArray(ARG_PARAM)!!
            .map { it as StepResponse }
            .toList()
        binding.stepsRv.adapter = CookingStepAdapter(steps)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun getInstance(steps : Array<StepResponse>) : CookingStepsFragment = CookingStepsFragment().apply {
            arguments = Bundle().apply {
                putParcelableArray(ARG_PARAM, steps)
            }
        }
    }
}