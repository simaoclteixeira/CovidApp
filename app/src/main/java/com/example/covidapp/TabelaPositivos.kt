package com.example.covidapp

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaPositivos(db: SQLiteDatabase) {
    private val db: SQLiteDatabase = db

    fun cria() {
        db.execSQL("CREATE TABLE $NOME_TABELA (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $CAMPO_NOME TEXT NOT NULL, $CAMPO_IDADE TEXT NOT NULL, $CAMPO_ID_SINTOMAS INTEGER NOT NULL, FOREIGN KEY($CAMPO_ID_SINTOMAS) REFERENCES ${TabelaSintomas.NOME_TABELA})")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaPositivos.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaPositivos.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaPositivos.NOME_TABELA, whereClause, whereArgs)
    }

    fun query(
        columns: Array<String>,
        selection: String,
        selectionArgs: Array<String>,
        groupBy: String,
        having: String,
        orderBy: String
    ): Cursor? {
        return db.query(TabelaPositivos.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }

    companion object {
        const val NOME_TABELA = "Casos Positivos"
        const val CAMPO_NOME = "titulo"
        const val CAMPO_IDADE = "autor"
        const val CAMPO_ID_SINTOMAS = "id_sintomas"
    }
}