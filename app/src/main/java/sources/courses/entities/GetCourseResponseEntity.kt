package sources.courses.entities

import app.model.ads.entities.Ad
import app.model.courses.entities.Course

class GetCourseResponseEntity(
    val id: Long,
    val title: String,
    val price: String,
    val image: Int
) {
    fun toCourse(): Course = Course(
        id = id,
        title= title,
        price = price,
        image = image
    )
}
