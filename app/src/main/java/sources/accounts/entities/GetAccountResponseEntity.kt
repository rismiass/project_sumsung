package sources.accounts.entities

import app.model.accounts.Account

data class GetAccountResponseEntity (
    val id: Long,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val aboutSelf: String,
    val patronymic: String,
    val historyWork: String,
    val photo: Int,
    val quality: String,
    val skills: String,
    val profession: String,
    val vk: String

){
    fun toAccount(): Account = Account(
        id = id,
        name= name,
        surname = surname,
        email = email,
        phone = phone,
        patronymic = patronymic,
        aboutSelf = aboutSelf,
        historyWork = historyWork,
        photo = photo,
        quality = quality,
        skills = skills,
        profession = profession,
        vk = vk


    )
}