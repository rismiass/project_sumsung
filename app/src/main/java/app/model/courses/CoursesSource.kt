package app.model.courses

import app.model.chats.entities.Chat
import app.model.courses.entities.Course

interface CoursesSource {
    suspend fun getCourses(): List<Course>
}
