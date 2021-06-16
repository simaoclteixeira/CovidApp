package pt.ipg.covid

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaLocalidade(db: SQLiteDatabase) {
    private val db : SQLiteDatabase = db


    fun cria(){
        db.execSQL("CREATE TABLE $NOME_TABELA (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $NOME_LOCALIDADE TEXT NOT NULL, $CODIGO_POSTAL TEXT NOT NULL)")
    }

    fun insert(values: ContentValues): Long {
        return db.insert(TabelaLocalidade.NOME_TABELA, null, values)
    }

    fun update(values: ContentValues, whereClause: String, whereArgs: Array<String>): Int {
        return db.update(TabelaLocalidade.NOME_TABELA, values, whereClause, whereArgs)
    }

    fun delete(whereClause: String, whereArgs: Array<String>): Int {
        return db.delete(TabelaLocalidade.NOME_TABELA, whereClause, whereArgs)
    }


    fun query(
        columns: Array<String>?,
        selection: String?,
        selectionArgs: Array<String>?,
        groupBy: String?,
        having: String?,
        orderBy: String?
    ): Cursor? {
        return db.query(TabelaLocalidade.NOME_TABELA, columns, selection, selectionArgs, groupBy, having, orderBy)
    }


    companion object{
        const val NOME_TABELA = "enfermeiros"
        const val NOME_LOCALIDADE = "nome"
        const val CODIGO_POSTAL = "numero"




        val TODAS_COLUNAS = arrayOf(BaseColumns._ID, NOME_LOCALIDADE, CODIGO_POSTAL)

    }
}