package br.com.ativa.screens.LoginScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel: ViewModel() {  //como estou herdando a classe, tem q colocar o construtor
    private val _username = MutableLiveData<String>() //dado mutavel do tipo string
    val username: LiveData<String> = _username //apenas leitura

    fun onUsernameChanged(newUsername: String) {
        _username.value = newUsername //funciona pois estou atualizando o valor e nao a referencia da constante
    }

    ///////////////////////////////////////////////////////

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail //funciona pois estou atualizando o valor e nao a referencia da constante
    }

    ///////////////////////////////////////////////////////

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword //funciona pois estou atualizando o valor e nao a referencia da constante
    }

    ///////////////////////////////////////////////////////

    private val _errorUsername = MutableLiveData<Boolean>()
    val errorUsername: LiveData<Boolean> = _errorUsername

    fun onErrorUsernameChanged(username: String) {
        _errorUsername.value = username.isEmpty()
    }

    ///////////////////////////////////////////////////////

    private val _errorEmail = MutableLiveData<Boolean>()
    val errorEmail: LiveData<Boolean> = _errorEmail

    fun onErrorEmailChanged(it: String) {
        _errorEmail.value = it.isEmpty() //funciona pois estou atualizando o valor e nao a referencia da constante
    }

    ///////////////////////////////////////////////////////

    private val _errorPassword = MutableLiveData<Boolean>()
    val errorPassword: LiveData<Boolean> = _errorPassword

    fun onErrorPasswordChanged(password: String) {
        _errorPassword.value = password.isEmpty()
    }

    fun checkInputError(username: String,  it: String, password: String, ifNoError: () -> Unit) {
        _errorUsername.value = username.isEmpty() //funciona pois estou atualizando o valor e nao a referencia da constante
        _errorEmail.value = it.isEmpty()
        _errorPassword.value = password.isEmpty()

        if (_errorUsername. value == false && _errorEmail.value == false && _errorPassword.value == false) { ifNoError() }
    }
}