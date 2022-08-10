package com.realityexpander.prepopulatedb.repositories

import com.realityexpander.prepopulatedb.data.PersonDao
import javax.inject.Inject

class PersonRepository @Inject constructor(
    val personDao: PersonDao
) {
    fun readAll() = personDao.readAll()
}