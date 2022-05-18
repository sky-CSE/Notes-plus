package com.example.notes.model

import java.time.LocalDateTime
import java.util.*

//De-sugaring is enabled in grade to use LocalDateTime in devices with Api <26
data class Note(
    val id: UUID = UUID.randomUUID(),//generates UUID by default for every note
    val title: String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
