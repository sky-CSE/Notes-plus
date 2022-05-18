package com.example.notes.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/*
" Modules are used to add bindings to Hilt "
In other words, to tell Hilt how to provide instances of diff types

To create a database, we would need to use a 'builder' to create an instance of DB
bc we don't want a DB created everytime the app starts.
 */
/*
SingletonComponent means one source of truth and we don't want it to be created in 2 diff instances
 */
@InstallIn(SingletonComponent::class)
@Module
object AppModule {
}