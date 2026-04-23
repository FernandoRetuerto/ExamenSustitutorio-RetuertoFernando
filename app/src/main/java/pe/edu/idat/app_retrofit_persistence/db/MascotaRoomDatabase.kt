package pe.edu.idat.app_retrofit_persistence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.idat.app_retrofit_persistence.db.dao.MascotaDao
import pe.edu.idat.app_retrofit_persistence.db.entity.MascotaEntity


@Database(entities = [MascotaEntity::class], version = 2)
abstract class MascotaRoomDatabase : RoomDatabase() {
    abstract fun mascotaDao() : MascotaDao

    companion object {
        @Volatile
        private var INSTANCE : MascotaRoomDatabase? = null

        fun getDatabase(context: Context) : MascotaRoomDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MascotaRoomDatabase::class.java,
                    "bdln72661761"
                ).fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }
}