package com.realityexpander.prepopulatedb.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Person::class],
    version = 1
)
//@TypeConverters(Converters::class)
abstract class PersonDatabase : RoomDatabase() {

    abstract fun getPersonDao(): PersonDao
}