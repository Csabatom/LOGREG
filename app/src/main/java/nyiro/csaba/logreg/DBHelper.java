package nyiro.csaba.logreg;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int Db_version = 1;
    public static final String Db_name = "Felhasznalok.db";
    public static final String felhasznalo_db = "felhasznalo";

    public static final String FELHASZNALO_TABLA = "felhasznalo";

    public static final String MEZO_ID = "id";
    public static final String MEZO_EMAIL = "email";
    public static final String MEZO_FELHASZNALONEV = "felhnev";
    public static final String MEZO_JELSZO = "jelszo";
    public static final String MEZO_TELJESNEV = "teljesnev";

    public DBHelper(Context context) {
        super(context, Db_name, null, Db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + FELHASZNALO_TABLA + " (" + MEZO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MEZO_EMAIL + " VARCHAR(255) NOT NULL UNIQUE," + MEZO_FELHASZNALONEV + " VARCHAR(255) NOT NULL UNIQUE," + MEZO_JELSZO + " VARCHAR(255) NOT NULL, " + MEZO_TELJESNEV + " INTEGER NOT NULL" + ")";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL = "DROP TABLE IF EXISTS " + FELHASZNALO_TABLA;
        db.execSQL(SQL);
        onCreate(db);
    }
}