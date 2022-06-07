package app.ui.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.chats.ChatsRepository
import app.model.courses.CoursesRepository
import kotlinx.coroutines.runBlocking

class CourseViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is course Fragment"
    }
    val text: LiveData<String> = _text

    val coursesRepository: CoursesRepository = Singletons.coursesRepository

    val listCourses = runBlocking {
        coursesRepository.getCourses()
    }
}