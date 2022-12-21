package com.example.kmmstarter.android.note_list

import com.example.kmmstarter.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val searchActive: Boolean = false,
)