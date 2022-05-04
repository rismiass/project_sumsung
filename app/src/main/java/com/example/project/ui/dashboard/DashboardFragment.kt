package com.example.project.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.project.HomeActivity
import com.example.project.R
import com.example.project.adaptor.AdaptorAdvertisement
import com.example.project.data.DataAdvertisement
import com.example.project.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
        //})
        val data = DataAdvertisement().loadList()
        val recyclerView = binding.listAdvertisements
        val adapter = context?.let { AdaptorAdvertisement(data, it) }
        recyclerView.adapter = adapter
        print(data)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}