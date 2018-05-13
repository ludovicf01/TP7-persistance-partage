package cnam.smb116.tp7persistanceetpartage;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.sql.SQLException;
import java.util.List;

public class MainListActivity extends ListActivity {
    private PermanenceDAO pDAO;
    private List<Permanence> result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste);
        pDAO = new PermanenceDAO(this);
        try {
            pDAO.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Permanence p1 = new Permanence("Dallas", "Korben", "korben.dallas@laplanete.fr");
        Permanence p2 = new Permanence("Sacquet", "Frodon", "frodon.sacquet@laplanete.fr");
        Permanence p3 = new Permanence("Skywalker", "Luck", "luck.skywalker@laplanete.fr");

        try{
            pDAO.create(p1);
            pDAO.create(p2);
            pDAO.create(p3);
        }catch (Exception e){
            e.printStackTrace();
        }

        AsyncTaskFindall findAll = new AsyncTaskFindall();
        findAll.execute(pDAO);
        try {
            result = findAll.get();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private class AsyncTaskFindall extends AsyncTask<PermanenceDAO, Void, List<Permanence>>{
        private Throwable cause = null;

        @Override
        protected List<Permanence> doInBackground(PermanenceDAO... db) {
            try {
                return db[0].findAll();
            }catch (Exception e) {
                cause = e;
                return null;
            }
        }

        @Override
        protected void onPostExecute(List<Permanence> permanences) {
            super.onPostExecute(permanences);
            try {
                PermanenceAdapter arrayAdapter = new PermanenceAdapter(
                        MainListActivity.this, R.layout.items_layout, result);
                setListAdapter(arrayAdapter);
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                pDAO.close();
            }
        }
    }
}
