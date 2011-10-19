package de.handwerker.kunden;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import de.handwerker.R;
import de.handwerker.model.Kunde;

public class KundenAdapter extends ArrayAdapter<Kunde> {
	
	Activity context;
	
	ArrayList<Kunde> kunden;

	public KundenAdapter(Context context, int textViewResourceId,
			List<Kunde> objects) {
		super(context, textViewResourceId, objects);
		this.context = (Activity) context;
		this.kunden = (ArrayList<Kunde>) objects;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.kunde, null);
        }
        
        Kunde k = kunden.get(position);
        if(k!=null){
            // name
            TextView nameTextView = (TextView) view.findViewById(R.id.textView1);
            nameTextView.setText(k.getName());

        }
        return view;        

	}

	
}
