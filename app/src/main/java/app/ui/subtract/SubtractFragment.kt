package app.ui.subtract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.adaptor.AdaptorChat
import com.example.project.databinding.FragmentNotificationsBinding

class SubtractFragment : Fragment() {

    private lateinit var subtractViewModel: SubtractViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subtractViewModel =
            ViewModelProvider(this).get(SubtractViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val data = subtractViewModel.listChats
        val recyclerView = binding.listChats
        val adapter = context?.let { AdaptorChat(data, it) }
        recyclerView.adapter = adapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}