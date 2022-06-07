package app.model.courses

import app.model.BackendException
import app.model.InvalidCredentialsException
import app.model.chats.ChatsSource
import app.model.chats.entities.Chat
import app.model.courses.entities.Course

class CoursesRepository(
    private val coursesSource: CoursesSource
) {
    suspend fun getCourses(): List<Course> {
        val lstCourses = try {
            coursesSource.getCourses()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }

        }
        return lstCourses
    }
}