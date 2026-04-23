package pe.edu.idat.app_retrofit_persistence.view.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

import pe.edu.idat.app_retrofit_persistence.R
import pe.edu.idat.app_retrofit_persistence.db.entity.MascotaEntity
class MascotaAdapter(private var lista: List<MascotaEntity>) :
    RecyclerView.Adapter<MascotaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val codigo = view.findViewById<TextView>(R.id.tvCodigo)
        val nombre = view.findViewById<TextView>(R.id.tvNombre)
        val tipo = view.findViewById<TextView>(R.id.tvTipo)
        val edad = view.findViewById<TextView>(R.id.tvEdad)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mascota, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = lista[position]

        holder.codigo.text = item.codmascota
        holder.nombre.text = item.nombre
        holder.tipo.text = item.tipo
        holder.edad.text = item.edad.toString()
    }

    override fun getItemCount() = lista.size

    fun actualizarDatos(nuevaLista: List<MascotaEntity>) {
        lista = nuevaLista
        notifyDataSetChanged()
    }
}