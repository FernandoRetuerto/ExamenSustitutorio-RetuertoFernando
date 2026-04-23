package pe.edu.idat.app_retrofit_persistence.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.idat.app_retrofit_persistence.R
import com.google.android.material.bottomnavigation.BottomNavigationView
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, ApiFragment())
            .commit()

        bottomNav.setOnItemSelectedListener { item ->

            when (item.itemId) {

                R.id.menu_api -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, ApiFragment())
                        .commit()
                    true
                }

                R.id.menu_mascotas -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, MascotasFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}