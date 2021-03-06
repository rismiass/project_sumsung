package app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.Singletons
import app.model.accounts.Account
import app.model.accounts.AccountRepository
import kotlinx.coroutines.runBlocking

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val sharedPreferencesAppSettings = Singletons.appSettings
    var account: Account
    private val accountsRepository: AccountRepository = Singletons.accountsRepository

    init {
        runBlocking { account = accountsRepository.getAccount() }

    }
}