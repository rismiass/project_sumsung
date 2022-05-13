package com.example.project.ui.subtract

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.project.adaptor.AdaptorAdvertisement
import com.example.project.adaptor.AdaptorChat
import com.example.project.data.DataAdvertisement
import com.example.project.data.DataChat
import com.example.project.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val data = DataChat().loadList()
        val recyclerView = binding.listChats
        val adapter = context?.let { AdaptorChat(data, it) }
        recyclerView.adapter = adapter
        print(data)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}