package cnam.smb116.tp7persistanceetpartage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ludo on 29/03/2017.
 */

public class PermanenceDAO implements IDAO<Permanence, Long>, DAOConstants {
    public final String[] ALL = new String[]{_ID,
            NOM_COLONNE_NOM,
            NOM_COLONNE_PRENOM,
            NOM_COLONNE_COURRIEL};

    private SQLiteDatabase db;
    private SQLiteOpenHelper dbHelper;
    private Context context;

    public PermanenceDAO(Context context){
        this.dbHelper = new PermanenceHelper(context);
        this.context = context;
    }

    public void open() throws SQLException{
        db = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void create(Permanence a) throws Exception{
        ContentValues values = new ContentValues();
        values.put(NOM_COLONNE_NOM, a.getNom());
        values.put(NOM_COLONNE_PRENOM, a.getPrenom());
        values.put(NOM_COLONNE_COURRIEL, a.getCourriel());
        db.insert(TABLE_PERMANENCES, null, values);
    }

    public Permanence retrieve(Long id)throws Exception{
        Cursor cursor = db.query(TABLE_PERMANENCES, ALL,
                _ID + "=" + id, null, null, null, null);
        cursor.moveToFirst();
        String nom = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_NOM));
        String prenom = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_PRENOM));
        String courriel = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_COURRIEL));
        cursor.close();
        return new Permanence(nom, prenom, courriel);
    }

    public void update(Permanence a) throws Exception{
        ContentValues values = new ContentValues();
        values.put(NOM_COLONNE_NOM, a.getNom());
        values.put(NOM_COLONNE_PRENOM, a.getPrenom());
        values.put(NOM_COLONNE_COURRIEL, a.getCourriel());
        db.update(TABLE_PERMANENCES, values, _ID + "=" + a.getId(), null);
    }

    public void delete(Long id) throws Exception{
        db.delete(TABLE_PERMANENCES, _ID
            + " = " + id, null);
    }

    public List<Permanence> findAll() throws Exception{
        List<Permanence> permanences = new ArrayList<Permanence>();

        Cursor cursor = db.query(TABLE_PERMANENCES, ALL, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String nom = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_NOM));
            String prenom = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_PRENOM));
            String courriel = cursor.getString(cursor.getColumnIndex(NOM_COLONNE_COURRIEL));
            Permanence a = new Permanence(nom,prenom,courriel);
            permanences.add(a);
            cursor.moveToNext();
        }
        cursor.close();
        return permanences;
    }

}
