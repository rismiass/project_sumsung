package app.ui.information

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.R
import androidx.navigation.findNavController
import com.example.project.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {
    private lateinit var informationViewModel: InformationViewModel
    private var _binding: FragmentInformationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        informationViewModel =
            ViewModelProvider(this).get(InformationViewModel::class.java)

        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textInformation
        //informationViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adviceLawyer.setOnClickListener {
            view.findNavController().navigate(R.id.action_informationFragment_to_adviceFragment)
        }
        binding.contacts.setOnClickListener {
            view.findNavController().navigate(R.id.action_informationFragment_to_contactsFragment)
        }
        binding.aboutCompany.setOnClickListener {
            view.findNavController().navigate(R.id.action_informationFragment_to_companyFragment)
        }
        binding.courses.setOnClickListener {
            view.findNavController().navigate(R.id.action_informationFragment_to_courseFragment)
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}