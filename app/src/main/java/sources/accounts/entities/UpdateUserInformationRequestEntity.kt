package sources.accounts.entities

data class UpdateUserInformationRequestEntity (
    val headersInformation: List<String>,
    val information: List<String>,
        )