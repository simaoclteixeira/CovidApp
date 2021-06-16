package com.example.covidapp

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

data class Utente(var id: Long = -1, var nome: String, var dnascimento: Long, var nrpaciente: Long, var idVacina : Long) {
    fun toContentValues(): ContentValues{
        val valores = ContentValues().apply {
            put(TabelaUtentes.CAMPO_NOME_UTENTE,nome)
            put(TabelaUtentes.CAMPO_DATA_NASCIMENTO,dnascimento)
            put(TabelaUtentes.CAMPO_NR_UTENTE,nrpaciente)
            put(TabelaUtentes.CAMPO_ID_VACINA,idVacina)
        }
        return valores
    }


    companion object{
        fun fromCursor(cursor: Cursor): Utente{
            val colunaId = cursor.getColumnIndex(BaseColumns._ID)
            val colunaNome = cursor.getColumnIndex(TabelaUtentes.CAMPO_NOME_UTENTE)
            val colunaDnascimento = cursor.getColumnIndex(TabelaUtentes.CAMPO_DATA_NASCIMENTO)
            val colunaNrpaciente = cursor.getColumnIndex(TabelaUtentes.CAMPO_NR_UTENTE)
            val colunaIdVacina = cursor.getColumnIndex(TabelaUtentes.CAMPO_ID_VACINA)

            val id= cursor.getLong(colunaId)
            val nome = cursor.getString(colunaNome)
            val dnascimento = cursor.getLong(colunaDnascimento)
            val nrpaciente = cursor.getLong(colunaNrpaciente)
            val idVacina = cursor.getLong(colunaIdVacina)

            return Utente(id ,nome ,dnascimento , nrpaciente,idVacina)

        }
    }
}