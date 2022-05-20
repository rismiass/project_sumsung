package sources.accounts

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import sources.accounts.entities.*

interface AccountApi {
    @POST("sign-in")
    suspend fun signIn(@Body signInRequestEntity: SignInRequestEntity): SignInResponseEntity

    @POST("sign-up")
    suspend fun signUp(@Body body: SignUpRequestEntity)

    @GET("get-information/{userId}")
    suspend fun getAccount(@Path("userId") userId: Long): GetAccountResponseEntity

    @POST("set-information/{userId}")
    suspend fun setInformation(@Path("userId") userId: Long,
                               @Body body: UpdateUserInformationRequestEntity)
}