package com.example.kmmstarter.data.note

import com.example.kmmstarter.domain.note.Note
import com.example.kmmstarter.domain.time.DateTimeUtil
import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun NoteEntity.toNote(): Note {
    return Note(
        id = this.id,
        title = this.title,
        content = this.content,
        colorHex = this.colorHEX,
        created = Instant.fromEpochMilliseconds(this.created)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}