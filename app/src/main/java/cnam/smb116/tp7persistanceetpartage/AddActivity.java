package cnam.smb116.tp7persistanceetpartage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.sql.SQLException;

public class AddActivity extends AppCompatActivity {
    private PermanenceDAO pDAO;
    private EditText editTextN, editTextP, editTextC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        pDAO = new PermanenceDAO(this);
        try {
            pDAO.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        editTextN = (EditText) findViewById(R.id.editTextN);
        editTextP = (EditText) findViewById(R.id.editTextP);
        editTextC = (EditText) findViewById(R.id.editTextC);

    }

    public void onClickOk(View v){
        Permanence p = new Permanence(editTextN.getText().toString(),
                editTextP.getText().toString(), editTextC.getText().toString());
        try {
            pDAO.create(p);
        }catch (Exception e){
            e.printStackTrace();
        }
        finish();
    }
}
