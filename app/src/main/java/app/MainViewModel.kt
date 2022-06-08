package app

import androidx.lifecycle.ViewModel
import app.Singletons.accountsRepository
import app.model.EmptyFieldException
import app.model.accounts.AccountRepository
import app.model.accounts.SignUpData
import app.model.ads.AdsRepository
import kotlinx.coroutines.runBlocking

class MainViewModel: ViewModel() {
    private val sharedPreferencesAppSettings = Singletons.appSettings
    private val accountsRepository: AccountRepository = Singletons.accountsRepository

    fun signIn(email: String, password: String) {
        val token = runBlocking {
                accountsRepository.signIn(
                    email,
                    password)}
        sharedPreferencesAppSettings.setCurrentToken(token)
    }

    fun processEmptyFieldException(e: Exception): String {
        return e.message.toString()
    }
    }