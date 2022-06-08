package sources.courses

import app.model.ads.AdsSource
import app.model.ads.entities.Ad
import app.model.courses.CoursesSource
import app.model.courses.entities.Course
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import okhttp3.Request
import sources.ads.entities.GetAdResponseEntity
import sources.base.BaseOkhttpSource
import sources.base.OkhttpConfig
import sources.courses.entities.GetCourseResponseEntity

class OkhttpCoursesSource(
    config: OkhttpConfig
) : BaseOkhttpSource(config), CoursesSource {
    override suspend fun getCourses(): List<Course> {
        val request = Request.Builder().get().endpoint("courses").build()
        val call = client.newCall(request)
        val typeToken = object : TypeToken<List<GetCourseResponseEntity>>() {}
        val response = call.suspendEnqueue().parseJsonResponse(typeToken)
        return response.map { it.toCourse() }
    }
}

