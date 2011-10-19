package de.handwerker.kunden;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import de.handwerker.R;
import de.handwerker.model.Kunde;

public class KundenActivity extends ListActivity{
   
    private ArrayList<Kunde> kundenList;
    private KundenAdapter kundenAdapter;
    
    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        kundenList = (ArrayList<Kunde>) getIntent().getSerializableExtra("kunden");
        kundenAdapter = new KundenAdapter(this, R.layout.kunde, kundenList);
        setListAdapter(kundenAdapter);
        
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        
        super.onListItemClick(l, v, position, id);
        Kunde kunde = kundenAdapter.getItem(position);
        
        String name = kunde.getName();
        if (name==null || name.length()==0) {
            longToast("Kein Kunde verfügbar");
            return;
        }
        longToast(name);
        
    }
    
    public void longToast(CharSequence message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

	
}
