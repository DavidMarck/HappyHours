package com.example.david.happyhours;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class accueil extends AppCompatActivity {

    private static Context context;

    private Toolbar toolbar;
    private ListView listViewDrawer,listViewBars;
    private final String[] drawerItems = new String[]{
            "Favoris","Barathon","Paramètres"
    };
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    private DatabaseDAO dbDAO;
    private BarDAO barDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

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

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // code de gestion quand click recherche à mettre ici

                // pour fermer la SearchView
                invalidateOptionsMenu();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    //gère le click sur une action de l'ActionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            // Gérer les 'case' ici
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
    * Initialisation des composants graphiques de l'interface de l'activité
    * */
    public void initialisations() {

        context = this.getApplicationContext();

        // Création et ouverture de la base de données par le DAO
        dbDAO = new DatabaseDAO(context);
        dbDAO.open();

        barDAO = new BarDAO(context);

        // Instanciation de la Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        // On définit notre Toolbar en tant qu'ActionBar
        setSupportActionBar(toolbar);

        // Affichage du bouton retour dans la Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // Instanciation d'un Drawer
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        this.drawerToggle = new ActionBarDrawerToggle(this,this.drawerLayout,0,0);
        this.drawerLayout.addDrawerListener(this.drawerToggle);

        // Instanciation et remplissage de la ListView contenue dans le Drawer
        listViewDrawer = (ListView) findViewById(R.id.listViewDrawer);
        ArrayAdapter<String> adapterDrawerItems = new ArrayAdapter<String>(accueil.this,
        android.R.layout.simple_list_item_1, drawerItems);
        listViewDrawer.setAdapter(adapterDrawerItems);

        // Instanciation et remplissage de la ListView listant les bars
        listViewBars = (ListView) findViewById(R.id.listViewBars);
        List<BarRow> barsRows = genererBars();
        BarAdapter adapterBarsRows = new BarAdapter(accueil.this,barsRows);
        listViewBars.setAdapter(adapterBarsRows);
    }

    /**
     * Génère les informations des bars à afficher dans la liste de l'accueil
     *
     * @return ArrayList de BarRow
     * (informations à afficher dans la ListView de l'activité accueil)
     */
    private List<BarRow> genererBars() {
        List<BarRow> barsRows = new ArrayList<BarRow>();
        List<Bar> barsBDD = barDAO.getAllBar();
        for(Bar unBar : barsBDD) {
            barsRows.add(new BarRow(unBar.getNom(),unBar.getHoraire_hh_deb(),
                    unBar.getHoraire_hh_fin(),unBar.getAdresse(),unBar.getHoraire_ouv(),
                    unBar.getHoraire_ferm()));
        }
        return barsRows;
    }
}
