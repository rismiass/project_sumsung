package sources.accounts

import app.model.accounts.Account
import app.model.accounts.AccountSource
import app.model.accounts.SignUpData
import app.model.wrapBackendExceptions
import kotlinx.coroutines.delay
import sources.accounts.entities.SignInRequestEntity
import sources.accounts.entities.SignUpRequestEntity
import sources.accounts.entities.UpdateUserInformationRequestEntity
import sources.base.BaseRetrofitSource
import sources.base.RetrofitConfig

class RetrofitAccountSource(
    config: RetrofitConfig
): BaseRetrofitSource(config), AccountSource {
    private  val accountApi = retrofit.create(AccountApi::class.java)

    override suspend fun signIn(email: String, password: String): String = wrapBackendExceptions{
        delay(1000)
        val signInRequestEntity = SignInRequestEntity(
            email = email,
            password = password
        )
        accountApi.signIn(signInRequestEntity).token
    }

    override suspend fun signUp(signUpData: SignUpData) = wrapBackendExceptions{
        delay(1000)
        val signUpRequestEntity = SignUpRequestEntity(
            email = signUpData.email,
            name = signUpData.name,
            surname = signUpData.surname,
            phone = signUpData.phone,
            password = signUpData.password
        )
        accountApi.signUp(signUpRequestEntity)
    }

    override suspend fun getAccount(userId: Long): Account = wrapBackendExceptions{
        delay(1000)
        accountApi.getAccount(userId).toAccount()
    }

    override suspend fun setInformationUser(
        userId: Long,
        headersInformation: List<String>,
        information: List<String>
    ) = wrapBackendExceptions{
        delay(1000)
        val updateUserInformationRequestEntity = UpdateUserInformationRequestEntity(
            headersInformation, information
        )
        accountApi.setInformation(userId, updateUserInformationRequestEntity)
    }
}