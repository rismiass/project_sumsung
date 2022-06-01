package sources.ads.entities

import app.model.ads.entities.Ad

data class GetAdResponseEntity(
    val id: Long,
    val profession:String,
    val salary: String,
    val working_days: String,
    val image: Long
) {
    fun toAd(): Ad = Ad(
        id = id,
        profession = profession,
        salary = salary,
        working_days = working_days,
        image = image
    )
}
