package pe.edu.idat.app_retrofit_persistence.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblfernando")
data class MascotaEntity(
    @PrimaryKey
    val codmascota: String,
    val nombre: String,
    val tipo: String,
    val edad: Int
)
