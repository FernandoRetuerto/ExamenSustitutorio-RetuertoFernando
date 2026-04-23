package pe.edu.idat.app_retrofit_persistence.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import pe.edu.idat.app_retrofit_persistence.retrofit.response.Product
import android.view.View
import pe.edu.idat.app_retrofit_persistence.R
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.widget.ImageView
import com.bumptech.glide.Glide
class ProductAdapter(private val lista: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val price = view.findViewById<TextView>(R.id.tvPrice)
        val category = view.findViewById<TextView>(R.id.tvCategory)
        val image = view.findViewById<ImageView>(R.id.imgProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = lista[position]

        holder.title.text = item.title
        holder.price.text = item.price.toString()
        holder.category.text = item.category

        Glide.with(holder.image.context)
            .load(item.thumbnail)
            .into(holder.image)
    }

    override fun getItemCount() = lista.size
}