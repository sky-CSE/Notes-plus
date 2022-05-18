package com.example.notes

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NoteApplication : Application() {
    /*
    This class extends the 'Application' viz top-level class that a project can hold.
    @HiltAndroidApp gives Hilt access to the entire application
    So what this does, it creates a dependency container as its called at top level

    In other words, Hilt can now supply dependencies to any part of the app

    To make this official, go to manifest and android:name = ".NoteApplication"
     */
}