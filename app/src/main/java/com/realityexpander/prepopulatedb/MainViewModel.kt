package com.realityexpander.prepopulatedb

import androidx.lifecycle.ViewModel
import com.realityexpander.prepopulatedb.repositories.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    personRepository: PersonRepository
): ViewModel() {

    val readAll = personRepository.readAll()
}