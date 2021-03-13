package hackathon.tastemydroid.ui.cookingsteps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hackathon.tastemydroid.databinding.FragCookingStepsBinding
import hackathon.tastemydroid.entities.CookingStep


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
        val adapter = CookingStepAdapter(
            listOf(
                CookingStep(
                    1,
                    "Вымытое и обсушенное куриное филе режем на куски толщиной 1 см."
                ),
                CookingStep(
                    2,
                    "Слегка отбиваем эти куски и нарезаем из них полоски."
                ),
                CookingStep(
                    3,
                    "Готовим соус. Для этого смешиваем в сотейнике сметану, томатную пасту и бульон. Солим и перчим по вкусу, доводим до кипения. Отставляем соус в сторону."
                ),
                CookingStep(
                    4,
                    "Куриное мясо панируем в муке, но потом его помещаем в дуршлаг, чтобы стряхнуть лишнюю муку."
                )
            )
        )
        binding.stepsRv.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}