package sources.accounts

import app.model.accounts.Account
import app.model.accounts.AccountSource
import app.model.accounts.MainInformationUser
import app.model.accounts.SignUpData
import kotlinx.coroutines.delay
import okhttp3.Request
import sources.accounts.entities.*
import sources.base.BaseOkhttpSource
import sources.base.OkhttpConfig

class OkhttpAccountSource(
    config: OkhttpConfig
): BaseOkhttpSource(config), AccountSource {

    override suspend fun signIn(email: String, password: String): String {
        delay(1000)
        val signInRequestEntity = SignInRequestEntity(
            email = email,
            password = password
        )

        val request = Request.Builder().
                post(signInRequestEntity.toJsonRequestBody())
            .endpoint("sign-in").build()
        val call = client.newCall(request)
        val response = call.suspendEnqueue()
        return response.parseJsonResponse<SignInResponseEntity>().token
    }

    override suspend fun signUp(signUpData: SignUpData) {
        delay(1000)
        val signUpRequestEntity = SignUpRequestEntity(
            email = signUpData.email,
            name = signUpData.name,
            surname = signUpData.surname,
            phone = signUpData.phone,
            password = signUpData.password
        )
        val request = Request.Builder()
            .post(signUpRequestEntity.toJsonRequestBody())
            .endpoint("/sign-up").build()
        client.newCall(request).suspendEnqueue()
    }

    override suspend fun getAccount(): Account {
        delay(1000)
        val request = Request.Builder()
            .get().endpoint("get-profile").build()
        val response = client.newCall(request).suspendEnqueue()
        val accountEntity = response.parseJsonResponse<GetAccountResponseEntity>()
        return accountEntity.toAccount()
    }

    override suspend fun setInformationUser(informationUser: MainInformationUser):String  {
        delay(1000)
        val request = Request.Builder()
            .post(informationUser.toJsonRequestBody())
            .endpoint("/set-information").build()
        val response = client.newCall(request).suspendEnqueue()
        val userEntity = response.parseJsonResponse<UpdateUserInformationRequestEntity>()
        return userEntity.status
    }
}