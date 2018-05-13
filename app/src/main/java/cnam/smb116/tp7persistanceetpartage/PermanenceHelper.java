package cnam.smb116.tp7persistanceetpartage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ludo on 29/03/2017.
 */

public class PermanenceHelper extends SQLiteOpenHelper implements DAOConstants {
    private static final String DATABASE_NAME = "auditeurs.db";
    private static final int DATABASE_VERSION = 1;


    public PermanenceHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String CREATION_BD =
            "CREATE TABLE " + TABLE_PERMANENCES + "(" +
            _ID + " integer primary key autoincrement, "+
            NOM_COLONNE_NOM + " nom, "+
            NOM_COLONNE_PRENOM + " text not null, "+
            NOM_COLONNE_COURRIEL + " text not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATION_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Supprimer la table");
        onCreate(db);
    }
}
