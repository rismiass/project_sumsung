package app.model.accounts

 interface AccountSource {
     /**
      * Авторизация пользователя
      * @return JWT-token
      */
     suspend fun signIn(email: String, password: String): String

     /**
      * Создаёт новый аккаунт
      */
     suspend fun signUp(signUpData: SignUpData)
     /**
      * Получает информацию о текущем залогированном пользователе
      */
     suspend fun getAccount(userId: Long): Account
     /**
      * Изменяет пользовательские данные
      */
     suspend fun setInformationUser(userId: Long, headersInformation: List<String>, information: List<String>)
 }