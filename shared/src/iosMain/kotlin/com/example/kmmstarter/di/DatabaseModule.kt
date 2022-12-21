package com.example.kmmstarter.di

import com.example.kmmstarter.data.local.DatabaseDriverFactory
import com.example.kmmstarter.data.note.SQLDelightNoteDataSource
import com.example.kmmstarter.domain.note.NoteDataSource
import com.plcoding.noteappkmm.database.NoteDatabase

class DatabaseModule {

    private val factory by lazy { DatabaseDriverFactory() }

    val noteDataSource: NoteDataSource by lazy {
        SQLDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}