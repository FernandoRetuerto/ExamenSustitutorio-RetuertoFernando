package pe.edu.idat.app_retrofit_persistence.view
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import androidx.lifecycle.Observer

import pe.edu.idat.app_retrofit_persistence.R
import pe.edu.idat.app_retrofit_persistence.db.MascotaRoomDatabase
import pe.edu.idat.app_retrofit_persistence.db.dao.MascotaDao
import pe.edu.idat.app_retrofit_persistence.view.adapter.MascotaAdapter
class MascotasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MascotaAdapter
    private lateinit var dao: MascotaDao

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_mascotas, container, false)

        recyclerView = view.findViewById(R.id.recyclerMascotas)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        adapter = MascotaAdapter(emptyList())
        recyclerView.adapter = adapter

        dao = MascotaRoomDatabase.getDatabase(requireContext()).mascotaDao()

        observarMascotas()

        return view
    }

    private fun observarMascotas() {

        dao.obtenerTodas().observe(viewLifecycleOwner, Observer { lista ->

            adapter.actualizarDatos(lista)
        })
    }
}