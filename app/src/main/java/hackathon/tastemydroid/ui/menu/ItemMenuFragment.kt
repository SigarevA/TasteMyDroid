package hackathon.tastemydroid.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hackathon.tastemydroid.R


class ItemMenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_menu, container, false)
    }

    companion object {
        @JvmStatic
        fun getInstance() =
            ItemMenuFragment()//.apply {
        //  arguments = Bundle().apply {
        //  }
    }
}
