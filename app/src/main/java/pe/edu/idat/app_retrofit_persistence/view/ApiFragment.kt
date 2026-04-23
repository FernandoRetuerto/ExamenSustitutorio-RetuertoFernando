package pe.edu.idat.app_retrofit_persistence.view
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import pe.edu.idat.app_retrofit_persistence.R
import pe.edu.idat.app_retrofit_persistence.retrofit.response.ProductResponse
import pe.edu.idat.app_retrofit_persistence.view.adapter.ProductAdapter



import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ApiFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_api, container, false)

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        obtenerProductos()

        return view
    }

    private fun obtenerProductos() {

        ClienteRetrofit.api.getProducts()
            .enqueue(object : retrofit2.Callback<ProductResponse> {

                override fun onResponse(
                    call: retrofit2.Call<ProductResponse>,
                    response: retrofit2.Response<ProductResponse>
                ) {
                    if (response.isSuccessful) {

                        val productos = response.body()?.products ?: emptyList()

                        val filtrados = productos.filter { it.price > 100 }

                        adapter = ProductAdapter(filtrados)
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(
                    call: retrofit2.Call<ProductResponse>,
                    t: Throwable
                ) {
                    Toast.makeText(requireContext(), "Error API", Toast.LENGTH_SHORT).show()
                }
            })
    }
}