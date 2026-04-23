import pe.edu.idat.app_retrofit_persistence.retrofit.response.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProducts(): Call<ProductResponse>
}