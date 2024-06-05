package br.com.locaweb.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginScreenViewModel {

    //EMAIL
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChanged(novoEmail: String){
        _email.value = novoEmail
    }

    //SENHA
    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    fun onSenhaChanged(novaSenha: String){
        _senha.value = novaSenha
    }


}