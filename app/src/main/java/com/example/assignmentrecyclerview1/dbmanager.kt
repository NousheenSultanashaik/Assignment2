package com.example.assignmentrecyclerview1
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
class DbManager(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    companion object {
        private const val DB_NAME = "addusers"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "tbl_contact"
        private const val ID = "id"
        private const val NAME = "name"
        private const val GENDER = "gender"
        private const val DOB = "dob"
        private const val DATE_TIME = "datetime"
        private const val EMAIL = "email"
        private const val BTECH_PASSOUT_YEAR = "btech_passout_year"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE $TABLE_NAME ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $NAME TEXT, $GENDER TEXT, $DOB TEXT, $DATE_TIME TEXT, $EMAIL TEXT, $BTECH_PASSOUT_YEAR TEXT)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addRecord(name: String, gender: String, dob: String, dateTime: String, email: String, btechPassoutYear: String): String {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(NAME, name)
            put(GENDER, gender)
            put(DOB, dob)
            put(DATE_TIME, dateTime)
            put(EMAIL, email)
            put(BTECH_PASSOUT_YEAR, btechPassoutYear)
        }
        val result = db.insert(TABLE_NAME, null, values)

        return if (result == -1L) {
            "Failed"
        } else {
            "Successfully inserted"
        }
    }


    fun readAllData(): Cursor? {
        val db = this.writableDatabase
        val query = "SELECT * FROM $TABLE_NAME ORDER BY $ID DESC"
        return db.rawQuery(query, null)
    }
}
