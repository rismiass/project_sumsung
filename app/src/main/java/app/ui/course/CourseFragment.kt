package app.ui.course

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.adaptor.AdaptorCourse
import com.example.project.databinding.FragmentCourseBinding

class CourseFragment : Fragment() {

    private var _binding: FragmentCourseBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var courseViewModel: CourseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        courseViewModel =
            ViewModelProvider(this).get(CourseViewModel::class.java)
        _binding = FragmentCourseBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val data = courseViewModel.listCourses
        val recyclerView = binding.listCourses
        val adapter = context?.let { AdaptorCourse(data, it) }
        recyclerView.adapter = adapter
        print(data)
        return root
    }

}