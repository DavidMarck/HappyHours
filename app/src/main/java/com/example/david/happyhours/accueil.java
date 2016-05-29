package com.example.david.happyhours;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import static android.support.v4.app.ActivityCompat.startActivity;

public class accueil extends AppCompatActivity {

    private static Context context;

    private Toolbar toolbar;
    private ListView listViewDrawer, listViewBars;
    private BarAdapter adapterBarsRows;
    private String[] drawerItems;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ImageButton btn_favori, btn_barathon, btn_geoloc;

    private DatabaseDAO dbDAO;
    private BarDAO barDAO;
    private OuvertureDAO ouvertureDAO;
    private JourDAO jourDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        setTitle("Happy Hours - Accueil");

        initialisations();
    }

    @Override
    /*
    * Méthode d'initialisation des actions du menu (dans la toolbar)
    * */
    public boolean onCreateOptionsMenu(Menu menu) {
        //ajoute les entrées de menu_toolbar à l'ActionBar (transformée en toolbar)
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        // Gestion du click sur la loupe (icône SearchView)
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterBarsRows.filter("");
                listViewBars.invalidate();
            }
        });

        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // code de gestion quand click recherche à mettre ici

                // pour fermer la SearchView
                invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String searchQuery) {
                adapterBarsRows.filter(searchQuery.toString().trim());
                listViewBars.invalidate();
                return true;
            }
        });

        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // Do something when collapsed
                return true;  // Return true to collapse action view
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                // Do something when expanded
                return true;  // Return true to expand action view
            }
        });

        searchView.setQueryHint("Recherchez un bar ici");

        return true;
    }

    //gère le click sur une action de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Gérer les 'case' ici
            case R.id.action_search:
                Toast toast = Toast.makeText(this.getApplicationContext(),
                        "Search View clicked", Toast.LENGTH_SHORT);
                toast.show();
                return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // synchroniser le drawerToggle après la restauration via onRestoreInstanceState
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Initialisations
     * --> Instanciations composants graphiques
     * --> Ouverture BDD (DAOs)
     */
    public void initialisations() {

        context = this.getApplicationContext();

        // Création et ouverture de la base de données par le DAO
        dbDAO = new DatabaseDAO(context);
        dbDAO.open();

        barDAO = new BarDAO(context);
        ouvertureDAO = new OuvertureDAO(context);
        jourDAO = new JourDAO(context);

        // Instanciation de la Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // On définit notre Toolbar en tant qu'ActionBar
        setSupportActionBar(toolbar);

        // Affichage du bouton retour dans la Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // On récupère les items du Drawer et on l'instancie
        this.drawerItems = getResources().getStringArray(R.array.drawer_array);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        // Instanciation et remplissage de la ListView contenue dans le Drawer
        listViewDrawer = (ListView) findViewById(R.id.listViewDrawer);
        ArrayAdapter<String> adapterDrawerItems = new ArrayAdapter<String>(accueil.this,
                android.R.layout.simple_list_item_1, drawerItems);
        listViewDrawer.setAdapter(adapterDrawerItems);
        // Ajout d'un OnItemClickListener à la liste
        listViewDrawer.setOnItemClickListener(new DrawerItemClickListener());

        this.drawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, 0, 0);
        this.drawerLayout.addDrawerListener(this.drawerToggle);

        // Instanciation et remplissage de la ListView listant les bars
        listViewBars = (ListView) findViewById(R.id.listViewBars);
        listViewBars.setTextFilterEnabled(true);
        List<BarRow> barsRows = genererItemsBars();
        adapterBarsRows = new BarAdapter(accueil.this, barsRows);
        listViewBars.setAdapter(adapterBarsRows);

        // Instanciation des ImageButtons
        btn_favori = (ImageButton) findViewById(R.id.btn_favori);

        btn_barathon = (ImageButton) findViewById(R.id.btn_barathon);

        btn_geoloc = (ImageButton) findViewById(R.id.btn_geoloc);
    }

    /**
     * Génère les items dans la liste de l'accueil
     *
     * @return ArrayList des items de type BarRow
     * (informations par bars à afficher dans la ListView de l'activité accueil)
     */
    private List<BarRow> genererItemsBars() {
        List<BarRow> barsRows = new ArrayList<BarRow>();
        List<Bar> barsBDD = barDAO.getAllBar();
        List<Ouverture> ouverturesBDD;
        List<Jour> joursBDD = jourDAO.getAllJour();

        String horaire_ouv = "";
        String horaire_ferm = "";
        String horaire_hh_deb = "";
        String horaire_hh_fin = "";

        // On récupère les informations relatives à l'horodatage
        Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
        // On récupère le numéro du jour de la semaine actuel via Calendar, qu'on modifie pour correspondre à la base de données (le jour 1 étant Dimanche dans Calendar et Lundi dans la base)
        int currentDayOfWeek = localCalendar.get(Calendar.DAY_OF_WEEK) == 1 ? 7 : (localCalendar.get(Calendar.DAY_OF_WEEK)) - 1;

        for (Bar unBar : barsBDD) {
            ouverturesBDD = ouvertureDAO.getAllOuverture(unBar.getId(), currentDayOfWeek);
            horaire_ouv = ouverturesBDD.get(0).getHoraire_ouv();
            horaire_ferm = ouverturesBDD.get(0).getHoraire_ferm();
            horaire_hh_deb = ouverturesBDD.get(0).getHoraire_hh_deb();
            horaire_hh_fin = ouverturesBDD.get(0).getHoraire_hh_fin();
            barsRows.add(new BarRow(unBar.getNom(), horaire_hh_deb,
                    horaire_hh_fin, unBar.getAdresse(), horaire_ouv,
                    horaire_ferm));
        }
        return barsRows;
    }

    /**
     * Classe de type Listener liée aux items du Drawer
     */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    /**
     * Actions lancées selon l'item sélectionné dans le drawer
     *
     * @param position numéro d'ordre de l'item dans la liste
     */
    private void selectItem(int position) {
        switch(position) {
            case 0:
                Intent accueil = new Intent(accueil.this, accueil.class);
                startActivity(accueil);
                break;
            case 1:
                Intent favoris = new Intent(accueil.this, favoris.class);
                startActivity(favoris);
                break;
            default:
        }
    }

}
