package br.com.locaweb.screens

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.locaweb.io.ApiService
import br.com.locaweb.io.ApiServiceConfig
import br.com.locaweb.io.request.LoginRequest
import br.com.locaweb.io.response.LoginResponse
import br.com.locaweb.io.response.ResponsePadrao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginScreenViewModel : ViewModel() {
    //EMAIL
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    fun onEmailChanged(novoEmail: String) {
        _email.value = novoEmail
    }

    //SENHA
    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    fun onSenhaChanged(novaSenha: String) {
        _senha.value = novaSenha
    }

    // Estado de login (sucesso/erro)
    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    // Mensagem de erro de login
    private val _loginError = MutableLiveData<String>()
    val loginError: LiveData<String> = _loginError

    // Mensagem de erro
    val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    val _mensagem = MutableLiveData<String?>()
    val mensagem: LiveData<String?> = _mensagem

    // Novo LiveData para indicar qual tema foi salvo com sucesso
    private val _themeSaved = MutableLiveData<String>()
    val themeSaved: LiveData<String> = _themeSaved

    private lateinit var sharedPreferences: SharedPreferences

    // Função de login
    fun login(context: Context) {
        val emailValue = _email.value
        val senhaValue = _senha.value

        val apiService = ApiServiceConfig.getInstance(context).createApiService()

        if (emailValue.isNullOrEmpty() || senhaValue.isNullOrEmpty()) {
            _loginError.value = "Email e senha são obrigatórios"
            return
        }

        val call = apiService.postLogin(LoginRequest(emailValue, senhaValue))

        call.enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    loginResponse?.let {
                        // Armazene o token JWT no SharedPreferences
                        sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
                        sharedPreferences.edit().putString("JWT_TOKEN", it.token).apply()

                        consultarPreferencias(it.token, context)
                        // Indica que o login foi bem-sucedido
                        _loginSuccess.value = true
                    }
                } else {
                    // Define mensagem de erro
                    _loginError.value = "Falha no login: ${response.message()}"
                    _loginSuccess.value = false
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                // Define mensagem de erro
                _loginError.value = "Erro de conexão: ${t.message}"
                _loginSuccess.value = false
            }
        })


    }

    private fun consultarPreferencias(token: String, context: Context) {
        val apiService = ApiServiceConfig.getInstance(context).createApiService()
        val call = apiService.getConsultarPreferencias()

        call.enqueue(object : Callback<ResponsePadrao> {
            override fun onResponse(call: Call<ResponsePadrao>, response: Response<ResponsePadrao>) {
                if (response.isSuccessful) {
                    val loginResponse = response.body()
                    var tema = "light"

                    loginResponse?.let {
                        val sharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
                        sharedPreferences.edit().putString("USER_THEME", it.retorno).apply()
                        // Indica que o login foi bem-sucedido
                        tema = it.retorno
                        _themeSaved.value = tema
                    }

                    _mensagem.value = "Tema atualizado para: $tema"
                } else {
                    _mensagem.value = "Erro ao consultar preferências: ${response.message()}"
                }
            }

            override fun onFailure(call: Call<ResponsePadrao>, t: Throwable) {
                _mensagem.value = "Erro: ${t.message}"
            }
        })
    }
}

