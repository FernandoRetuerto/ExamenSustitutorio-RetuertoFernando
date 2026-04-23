import retrofit2.Retrofit
import pe.edu.idat.app_retrofit_persistence.util.Constantes
import retrofit2.converter.gson.GsonConverterFactory

object ClienteRetrofit {

    val api: ApiService by lazy {

        Retrofit.Builder()
            .baseUrl(Constantes.URL_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}