package pe.edu.idat.app_retrofit_persistence.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.idat.app_retrofit_persistence.db.entity.MascotaEntity


@Dao
interface MascotaDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertar(mascota: MascotaEntity)

    @Update
    fun actualizar(mascota: MascotaEntity)

    @Query("DELETE FROM tblfernando")
    fun eliminarTodo()

    @Query("SELECT * FROM tblfernando")
    fun obtenerTodas(): LiveData<List<MascotaEntity>>

    @Query("SELECT * FROM tblfernando WHERE codmascota = :codmascota LIMIT 1")
    fun buscarPorCodigo(codmascota: String): MascotaEntity?
}