package br.com.locaweb.screens

import android.app.Application
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.locaweb.io.ApiService
import br.com.locaweb.io.ApiServiceConfig
import br.com.locaweb.io.request.PreferenciasRequest
import br.com.locaweb.io.response.ResponsePadrao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TelaConfiguracoesViewModel : ViewModel() {

    private val _salvoSucesso = MutableLiveData<Boolean>()
    val salvoSucesso: LiveData<Boolean> = _salvoSucesso

    private val _mensagem = MutableLiveData<String>()
    val mensagem: LiveData<String> = _mensagem

    // Novo LiveData para indicar qual tema foi salvo com sucesso
    private val _themeSaved = MutableLiveData<String>()
    val themeSaved: LiveData<String> = _themeSaved

    fun gravar(theme: String, context: Context) {
        val apiService = ApiServiceConfig.getInstance(context).createApiService()

        val call = apiService.postAtualizaPreferencias(PreferenciasRequest(theme))

        call.enqueue(object : Callback<ResponsePadrao> {
            override fun onResponse(call: Call<ResponsePadrao>, response: Response<ResponsePadrao>) {
                if (response.isSuccessful) {
                    _mensagem.value = "Sucesso!"
                    _salvoSucesso.value = true
                    _themeSaved.value = theme // Salva o tema quando a resposta for bem-sucedida
                } else {
                    _mensagem.value = "Falha: ${response.message()}"
                    _salvoSucesso.value = false
                }
            }

            override fun onFailure(call: Call<ResponsePadrao>, t: Throwable) {
                _mensagem.value = "Falha: ${t.message}"
                _salvoSucesso.value = false
            }
        })
    }
}

