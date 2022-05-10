package com.example.project.ui.course

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.R
import com.example.project.adaptor.AdaptorCourse
import com.example.project.data.DataCourse
import com.example.project.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var viewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = DataCourse().loadList()
        val recyclerView = binding.listCourses
        val adapter = context?.let { AdaptorCourse(data, it) }
        recyclerView.adapter = adapter
        print(data)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CourseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}