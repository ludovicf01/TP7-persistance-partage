package cnam.smb116.tp7persistanceetpartage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by ludo on 31/03/2017.
 */

public class PermanenceAdapter extends ArrayAdapter<Permanence> {
    private List<Permanence> objets;

    public PermanenceAdapter(Context context, int textViewResourceID,
                             List<Permanence> objets){
        super(context, textViewResourceID, objets);
        this.objets =objets;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = convertView;
        if (v==null){
            LayoutInflater inflater = (LayoutInflater) getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.items_layout, null);
        }
        Permanence p = objets.get(position);
        if (p != null){
            //TextView tid = (TextView)v.findViewById(R.id.id);
            TextView tn = (TextView)v.findViewById(R.id.tn);
            TextView tp = (TextView)v.findViewById(R.id.tp);
            TextView tc = (TextView)v.findViewById(R.id.tc);
            //if (tid != null){tid.setText(p.getId());}
            if (tn != null){tn.setText(p.getNom());}
            if (tp != null){tp.setText(p.getPrenom());}
            if (tc != null){tc.setText(p.getCourriel());}
        }
        return v;
    }
}
