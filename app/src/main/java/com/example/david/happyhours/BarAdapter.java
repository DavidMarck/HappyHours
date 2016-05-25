package com.example.david.happyhours;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by David on 23/05/2016.
 */
public class BarAdapter extends ArrayAdapter<BarRow> {

    /**
     * Constructeur
     *
     * @param context
     * @param bars liste contenant toutes les informations relatives aux bars à afficher
     */
    public BarAdapter(Context context, List<BarRow> bars) {
        super(context,0,bars);
    }

    /**
     * Instancie les vues (items de listViewBars) ou les ré-utilise
     *
     * @param position
     * @param convertView vue recyclée
     * @param parent
     * @return vue recyclée
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Android fournit un convertView null lorsqu'il nous demande de la créer
        // dans le cas contraire, cela veux dire qu'il nous fournit une vue recyclée
        if(convertView == null){
            // On récupère row_bar via un LayoutInflater,
            // qui va charger un layout xml dans un objet View
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_bar,parent, false);
        }

        BarViewHolder viewHolder = (BarViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new BarViewHolder();
            viewHolder.bar_nom = (TextView) convertView.findViewById(R.id.bar_nom);
            viewHolder.bar_hh = (TextView) convertView.findViewById(R.id.bar_hh);
            viewHolder.bar_adresse = (TextView) convertView.findViewById(R.id.bar_adresse);
            viewHolder.bar_horaires = (TextView) convertView.findViewById(R.id.bar_horaires);
            viewHolder.btn_favori = (ImageButton) convertView.findViewById(R.id.btn_favori);
            viewHolder.btn_barathon = (ImageButton) convertView.findViewById(R.id.btn_barathon);
            viewHolder.btn_geoloc = (ImageButton) convertView.findViewById(R.id.btn_geoloc);
            convertView.setTag(viewHolder);
        }

        // getItem(position) récupère l'item [position] de la List<BarRow> barsRows
        BarRow barRow = getItem(position);

        // Remplissage de la vue
        viewHolder.bar_nom.setText(barRow.getNom());
        viewHolder.bar_hh.setText(barRow.getHappy_hours());
        viewHolder.bar_adresse.setText(barRow.getAdresse());
        viewHolder.bar_horaires.setText(barRow.getHoraires());
        viewHolder.bar_adresse.setText(barRow.getAdresse());
        viewHolder.btn_favori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageButton imgBtn = (ImageButton) v;
                if(imgBtn.getTag().equals("R.drawable.ic_favorite_disabled")) {
                    imgBtn.setImageResource(R.drawable.ic_favorite_enabled);
                    imgBtn.setTag("R.drawable.ic_favorite_enabled");
                    genererToast("Bar ajouté aux favoris",500);
                } else {
                    imgBtn.setImageResource(R.drawable.ic_favorite_disabled);
                    imgBtn.setTag("R.drawable.ic_favorite_disabled");
                    genererToast("Bar retiré des favoris",500);
                }
            }
        });
        viewHolder.btn_barathon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genererToast("btn_barathon is clicked!",500);
            }
        });
        viewHolder.btn_geoloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genererToast("btn_geoloc is clicked!",500);
            }
        });

        return convertView;
    }

    private class BarViewHolder {
        public TextView bar_nom,bar_hh,bar_adresse,bar_horaires;
        public ImageButton btn_favori,btn_barathon,btn_geoloc;
    }

    /**
     * Génère un Toast, l'affiche et l'annule après une duree
     *
     * @param text
     * @param duree
     */
    public void genererToast(String text, int duree) {
        final Toast toast = Toast.makeText(getContext(),
                text, Toast.LENGTH_SHORT);
        toast.show();
        // N'afficher le Toast que 500ms et l'annuler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, duree);
    }
}
