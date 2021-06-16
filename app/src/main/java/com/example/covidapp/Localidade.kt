package com.example.covidapp

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.time.LocalDate
import java.util.*

data class Localidade(var id: Long = -1, var data: Date, var localidade: String) {
    fun toContentValues() : ContentValues{
        val valores = ContentValues().apply {
            put(TabelaVacinas.CAMPO_DATA,data.time)
            put(TabelaVacinas.CAMPO_ID_LOCALIDADE,localidade)

        }
        return valores
    }

    companion object{
        fun fromCursor(cursor: Cursor) : Localidade{
            val colunaId = cursor.getColumnIndex(BaseColumns._ID)
            val colunaData = cursor.getColumnIndex(TabelaVacinas.CAMPO_DATA)
            val colunaLocalidade = cursor.getColumnIndex(TabelaVacinas.CAMPO_ID_LOCALIDADE)

            val id = cursor.getLong(colunaId)
            val data = Date(cursor.getLong(colunaData))
            val localidade = cursor.getString(colunaLocalidade)


            return Localidade( id, data, localidade)
        }
    }
}