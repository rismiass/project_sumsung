package app.ui.settingsself

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
import com.example.project.databinding.FragmentSelfSettingsBinding

class SelfSettingsFragment : Fragment() {

    private var _binding: FragmentSelfSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: SettingsSelfViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SettingsSelfViewModel::class.java)
        _binding = FragmentSelfSettingsBinding.inflate(inflater, container, false)
        textFilling()
        binding.applyButton.setOnClickListener {
            val stat = viewModel.buttonPressed(
                binding.quality.text.toString(), binding.skills.text.toString(),
                binding.profession.text.toString(), binding.vk.text.toString(), binding.vk.text.toString()
            )
            Toast.makeText(
                context, stat,
                Toast.LENGTH_SHORT
            ).show()
        }
        val root: View = binding.root
        return root

    }
    fun  textFilling() {
        val data = viewModel.listSettings
        binding.quality.text = data[0].textSettings.toEditable()
        binding.nameQuality.text = data[0].titleSettings.toEditable()
        binding.skills.text = data[1].textSettings.toEditable()
        binding.nameSkills.text = data[1].titleSettings.toEditable()
        binding.profession.text = data[2].textSettings.toEditable()
        binding.nameProfession.text = data[2].titleSettings.toEditable()
        binding.vk.text = data[3].textSettings.toEditable()
        binding.nameVk.text = data[3].titleSettings.toEditable()
    }

    fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)




}