package br.com.locaweb.io

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiServiceConfig private constructor(context: Context) {

    private val jwtToken: String? = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)
        .getString("JWT_TOKEN", null)

    private val client = createClient(jwtToken != null)

    private fun createClient(withToken: Boolean): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                if (withToken) {
                    addInterceptor { chain ->
                        val originalRequest = chain.request()
                        val requestWithToken = originalRequest.newBuilder()
                            .header("Authorization", "Bearer ${jwtToken}")
                            .build()
                        chain.proceed(requestWithToken)
                    }
                }
            }
            .build()
    }

    fun createApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    companion object {
        private const val BASE_URL = "http://192.168.0.148:8080/"
        private var instance: ApiServiceConfig? = null

        fun getInstance(context: Context): ApiServiceConfig {
            if (instance == null) {
                instance = ApiServiceConfig(context)
            }
            return instance!!
        }
    }
}
