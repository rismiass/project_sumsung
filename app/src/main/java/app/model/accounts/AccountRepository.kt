package app.model.accounts

import android.text.Editable
import app.model.BackendException
import app.model.*
import app.model.InvalidCredentialsException
import app.model.settings.AppSettings
import sources.accounts.OkhttpAccountSource

class AccountRepository(
    private val accountsSource: AccountSource
) {

    suspend fun signIn(email: String, password: String): String {
        if (email.isBlank()) throw EmptyFieldException(Field.Email)
        if (password.isBlank()) throw EmptyFieldException(Field.Password)
        val token = try {
            accountsSource.signIn(email, password)
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }

        }
        return token
        // success! got auth token -> save it
        // and load account data
        //accountLazyFlowSubject.updateAllValues(accountsSource.getAccount())
    }


    suspend fun getAccount(): Account {
        val account = try {
            accountsSource.getAccount()
        } catch (e: Exception) {
            if (e is BackendException && e.code == 401) {
                // map 401 error for sign-in to InvalidCredentialsException
                throw InvalidCredentialsException(e)
            } else {
                throw e
            }

        }
        return account
    }

}