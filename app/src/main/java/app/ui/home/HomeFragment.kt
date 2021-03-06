package app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.adapters.RadioGroupBindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.Singletons
import com.example.project.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    ///private var _binding: FragmentHomeBinding? = null
///
    ///// This property is only valid between onCreateView and
    ///// onDestroyView.
    ///private val binding get() = _binding!!
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        var bar = binding.progressBar
        bar.visibility = ProgressBar.VISIBLE
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val account = homeViewModel.account
        binding.dataUser.text = "${account.name}\n${account.patronymic}\n${account.surname}\n${account.email}\n${account.phone}"
        binding.textUser.text = account.aboutSelf
        binding.workUser.text = account.historyWork
        bar.visibility = ProgressBar.INVISIBLE
        val root: View = binding.root
        return root
    }


    //override fun onDestroyView() {
    //    super.onDestroyView()
    //    _binding = null
    //}
}