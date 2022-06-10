package app.model.accounts

class Account(
    val id: Long,
    val name: String,
    val surname: String,
    val patronymic: String,
    val email: String,
    val phone: String,
    val aboutSelf: String,
    val historyWork: String,
    val photo: Int
)