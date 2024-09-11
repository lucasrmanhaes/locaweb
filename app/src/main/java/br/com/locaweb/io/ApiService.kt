package br.com.locaweb.io

import br.com.locaweb.io.request.LoginRequest
import br.com.locaweb.io.request.PreferenciasRequest
import br.com.locaweb.io.response.LoginResponse
import br.com.locaweb.io.response.ResponsePadrao
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiService {

    @POST("auth/login")
    fun postLogin(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("api/usuario/preferencias")
    fun postAtualizaPreferencias(@Body preferencias: PreferenciasRequest): Call<ResponsePadrao>

    @GET("api/usuario/consultarpreferencias")
    fun getConsultarPreferencias(): Call<ResponsePadrao>
}
