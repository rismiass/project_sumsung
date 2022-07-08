package app.ui.settingsself

import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.accounts.Account
import app.model.accounts.AccountRepository
import app.model.dataclasses.ItemSettings
import kotlinx.coroutines.runBlocking

class SettingsSelfViewModel : ViewModel() {
    var account: Account
    private val accountsRepository: AccountRepository = Singletons.accountsRepository

    val listSettings: List<ItemSettings>

    init {
        runBlocking { account = accountsRepository.getAccount() }
        listSettings = arrayListOf(
            ItemSettings("Качества", account.quality),
            ItemSettings("Навыки", account.skills),
            ItemSettings("Профессия и минимальная зарплата", account.profession),
            ItemSettings("Instagram/ВК", account.vk)
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