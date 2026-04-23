package pe.edu.idat.app_retrofit_persistence.view
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import pe.edu.idat.app_retrofit_persistence.db.dao.MascotaDao
import android.os.Bundle
import pe.edu.idat.app_retrofit_persistence.R
import pe.edu.idat.app_retrofit_persistence.db.MascotaRoomDatabase
import android.content.Intent
import android.widget.Toast
import pe.edu.idat.app_retrofit_persistence.db.entity.MascotaEntity

class RegistroActivity : AppCompatActivity() {

    private lateinit var etCodigo: EditText
    private lateinit var etNombre: EditText
    private lateinit var etTipo: EditText
    private lateinit var etEdad: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnIngresar: Button

    private lateinit var dao: MascotaDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        dao = MascotaRoomDatabase.getDatabase(this).mascotaDao()

        initViews()
        eventos()
    }

    private fun initViews() {
        etCodigo = findViewById(R.id.etCodigo)
        etNombre = findViewById(R.id.etNombre)
        etTipo = findViewById(R.id.etTipo)
        etEdad = findViewById(R.id.etEdad)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnIngresar = findViewById(R.id.btnIngresar)
    }

    private fun eventos() {

        btnGuardar.setOnClickListener {
            guardarMascota()
        }

        btnIngresar.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun guardarMascota() {

        val codigo = etCodigo.text.toString().trim()
        val nombre = etNombre.text.toString().trim()
        val tipo = etTipo.text.toString().trim()
        val edadStr = etEdad.text.toString().trim()

        if (codigo.isEmpty() || nombre.isEmpty() || tipo.isEmpty() || edadStr.isEmpty()) {
            Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            return
        }

        val edad = edadStr.toIntOrNull()
        if (edad == null || edad <= 0) {
            Toast.makeText(this, "La edad debe ser mayor a 0", Toast.LENGTH_SHORT).show()
            return
        }

        val existe = dao.buscarPorCodigo(codigo)

        if (existe != null) {
            Toast.makeText(this, "El código ya existe", Toast.LENGTH_SHORT).show()
            return
        }

        val mascota = MascotaEntity(
            codmascota = codigo,
            nombre = nombre,
            tipo = tipo,
            edad = edad
        )

        dao.insertar(mascota)

        Toast.makeText(this, "Mascota registrada", Toast.LENGTH_SHORT).show()

        limpiar()
    }

    private fun limpiar() {
        etCodigo.setText("")
        etNombre.setText("")
        etTipo.setText("")
        etEdad.setText("")
    }
}