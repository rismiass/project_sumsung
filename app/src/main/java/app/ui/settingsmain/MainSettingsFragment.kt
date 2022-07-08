package app.ui.settingsmain

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.iterator
import app.Singletons
import app.adaptor.AdaptorAdvertisement
import app.data.DataSettingsMain
import app.ui.settings.SettingsViewModel
import com.example.project.R
import com.example.project.databinding.FragmentMainSettingsBinding
import com.example.project.databinding.FragmentSettingsBinding

class MainSettingsFragment : Fragment() {

    private var _binding: FragmentMainSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainSettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(MainSettingsViewModel::class.java)
        _binding = FragmentMainSettingsBinding.inflate(inflater, container, false)
        val data = viewModel.listSettings
        binding.surname.text = data[0].textSettings.toEditable()
        binding.name.text = data[1].textSettings.toEditable()
        binding.patronymic.text = data[2].textSettings.toEditable()
        binding.email.text = data[3].textSettings.toEditable()
        binding.phone.text = data[4].textSettings.toEditable()
        binding.applyButton.setOnClickListener {
            val stat = viewModel.buttonPressed(
                binding.surname.text.toString(), binding.name.text.toString(),
                binding.patronymic.text.toString(), binding.email.text.toString(),
                binding.phone.text.toString()
            )
            Toast.makeText(
                context, stat,
                Toast.LENGTH_SHORT
            ).show()
        }
        val root: View = binding.root
        return root

    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)




}