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
     suspend fun getAccount(): Account
     /**
      * Изменяет пользовательские данные
      */
     suspend fun setInformationUser(informationUser: MainInformationUser): String
 }