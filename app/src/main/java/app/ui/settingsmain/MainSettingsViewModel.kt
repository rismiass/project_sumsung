package app.ui.settingsmain

import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.accounts.Account
import app.model.accounts.AccountRepository
import app.model.dataclasses.ItemSettings
import kotlinx.coroutines.runBlocking

class MainSettingsViewModel : ViewModel() {
    var account: Account
    private val accountsRepository: AccountRepository = Singletons.accountsRepository

    val listSettings: List<ItemSettings>

    init {
        runBlocking { account = accountsRepository.getAccount() }
        listSettings = arrayListOf(
            ItemSettings("Фамилия", account.surname),
            ItemSettings("Имя", account.name),
            ItemSettings("Отчество", account.patronymic),
            ItemSettings("Электронная почта", account.email),
            ItemSettings("Номер телефона", account.phone)
        )
    }

    fun buttonPressed(surname: String, name: String, patronymic: String, email: String, phone: String): String {
        val status = runBlocking {
             accountsRepository.setAccount(
                name = name, surname = surname, phone = phone, email = email, patronymic = patronymic
            )
        }
        return status
    }
}