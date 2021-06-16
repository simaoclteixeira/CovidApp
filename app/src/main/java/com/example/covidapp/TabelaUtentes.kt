package com.example.covidapp

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaUtentes(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME_UTENTE TEXT NOT NULL, $CAMPO_DATA_NASCIMENTO TEXT NOT NULL, $CAMPO_NR_UTENTE NUMERIC NOT NULL, FOREIGN KEY (${CAMPO_ID_VACINA}) REFERENCES ${TabelaVacina.NOME_TABELA})")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaUtentes.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaUtentes.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaUtentes.NOME_TABELA, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(TabelaUtentes.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOME_TABELA = "TabelaUtentes"
        const val CAMPO_NOME_UTENTE = "Nome"
        const val CAMPO_NR_UTENTE = "NumeroUtente"
        const val CAMPO_DATA_NASCIMENTO = "DataNascimento"
        const val CAMPO_ID_VACINA = "IdVacina"


        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, CAMPO_NOME_UTENTE, CAMPO_DATA_NASCIMENTO, CAMPO_ID_VACINA)
    }
}