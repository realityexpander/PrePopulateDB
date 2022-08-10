package com.realityexpander.prepopulatedb.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonDao {

    @Query("SELECT * FROM person")
    fun readAll(): Flow<List<Person>>
}