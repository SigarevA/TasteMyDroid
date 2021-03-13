package hackathon.tastemydroid.ui.menu

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import hackathon.tastemydroid.R


private const val DAY_ID = "dayID"

class ItemMenuFragment : Fragment() {

    private lateinit var listener : Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Listener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        // TODO change day
        fab.setOnClickListener { listener.clickFab(2) }
    }

    companion object {
        @JvmStatic
        fun getInstance(daysId: Int) =
            ItemMenuFragment().apply {
                arguments = Bundle().apply {
                    putInt(DAY_ID, daysId)
                }
            }
    }

    interface Listener {
        fun clickFab(daysId : Int)
    }
}