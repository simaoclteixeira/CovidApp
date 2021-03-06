package com.example.covidapp

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns
import java.time.LocalDate
import java.util.*

data class Vacina(var id: Long = -1, var nomeVacina: String, var data: Date, var localidade: String) {
    fun toContentValues() : ContentValues{
        val valores = ContentValues().apply {
            put(TabelaVacinas.CAMPO_NOME_VACINA,nomeVacina)
            put(TabelaVacinas.CAMPO_DATA,data.time)
            put(TabelaVacinas.CAMPO_ID_LOCALIDADE,localidade)

        }
        return valores
    }

    companion object{
        fun fromCursor(cursor: Cursor) : Vacina{
            val colunaId = cursor.getColumnIndex(BaseColumns._ID)
            val colunaNomeVacina = cursor.getColumnIndex(TabelaVacinas.CAMPO_NOME_VACINA)
            val colunaData = cursor.getColumnIndex(TabelaVacinas.CAMPO_DATA)
            val colunaLocalidade = cursor.getColumnIndex(TabelaVacinas.CAMPO_ID_LOCALIDADE)

            val id = cursor.getLong(colunaId)
            val nomeVacina = cursor.getString(colunaNomeVacina)
            val data = Date(cursor.getLong(colunaData))
            val localidade = cursor.getString(colunaLocalidade)


            return Vacina( id,nomeVacina,data, localidade)
        }
    }
}