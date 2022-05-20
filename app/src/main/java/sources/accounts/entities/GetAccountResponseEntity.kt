package sources.accounts.entities

import app.model.accounts.Account

data class GetAccountResponseEntity (
    val id: Long,
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val aboutSelf: String,
    val historyWork: String,
    val photo: Int
){
    fun toAccount(): Account = Account(
        id = id,
        name= name,
        surname = surname,
        email = email,
        phone = phone,
        aboutSelf = aboutSelf,
        historyWork = historyWork,
        photo = photo

    )
}