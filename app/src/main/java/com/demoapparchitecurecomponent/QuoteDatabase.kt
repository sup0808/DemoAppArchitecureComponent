package com.demoapparchitecurecomponent

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Quote::class], version = 1)
abstract class QuoteDatabase :RoomDatabase() {


    abstract fun getDao() : QuoteDao

  /*  companion object{  // removed after Dependancy injection
        @Volatile
        private var INSTANCE : QuoteDatabase? = null
        fun getDatabase(context: Context) :QuoteDatabase{
            if(INSTANCE ==null){
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        QuoteDatabase::class.java,
                        "QuotesDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }*/
}