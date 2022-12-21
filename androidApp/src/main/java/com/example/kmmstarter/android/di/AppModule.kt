package com.example.kmmstarter.android.di

import android.app.Application
import com.example.kmmstarter.data.local.DatabaseDriverFactory
import com.example.kmmstarter.data.note.SQLDelightNoteDataSource
import com.example.kmmstarter.domain.note.NoteDataSource
import com.plcoding.noteappkmm.database.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideDataSource(driver: SqlDriver): NoteDataSource {
        return SQLDelightNoteDataSource(NoteDatabase(driver))
    }
}