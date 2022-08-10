package com.realityexpander.prepopulatedb.di

import android.content.Context
import android.os.Environment
import androidx.room.Room
import com.realityexpander.prepopulatedb.data.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): PersonDatabase {

        return Room.databaseBuilder(
            context,
            PersonDatabase::class.java,
            "database"
        )
            .fallbackToDestructiveMigration()
            //.createFromFile(File(Environment.getExternalStorageDirectory().toString()) // For downloaded files
            .createFromAsset("database/person_db.db")
            .build()
    }

    @Singleton
    @Provides
    fun provideDao(database: PersonDatabase) = database.getPersonDao()
}