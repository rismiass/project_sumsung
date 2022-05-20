package sources.accounts.entities

data class SignUpRequestEntity (
    val name: String,
    val surname: String,
    val email: String,
    val phone: String,
    val password: String
)