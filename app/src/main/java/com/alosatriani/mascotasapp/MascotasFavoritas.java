package com.alosatriani.mascotasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;
import java.util.Collections;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<MascotasVO> mascotas;
    ArrayList<MascotasVO> mascotasFavoritas;
    private RecyclerView rvListaMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        ImageView starIV = (ImageView) findViewById(R.id.star);
        starIV.setVisibility(View.GONE);

        //Activamos el ToolBar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //DefaultDisplayHomeAsUpEnabled(true);
        //miActionBar.setDis

        rvListaMascotasFavoritas = (RecyclerView)findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotasFavoritas.setLayoutManager(llm);

        inicializarListaMascotas(getIntent());

        inicializarAdaptadorMascotas();


    }


    public void inicializarListaMascotas(Intent intent){
        Bundle bdl = intent.getExtras();
        mascotasFavoritas = new ArrayList<MascotasVO>();
        ArrayList<MascotasVO> listaMascotas = (ArrayList<MascotasVO> )intent.getSerializableExtra("MascotasVO");

        Collections.sort(listaMascotas);

        int cont = 0;
        for(MascotasVO mascota: listaMascotas) {
            if(mascota.getRating()>0 && cont <5){
                mascotasFavoritas.add(mascota);
                cont++;
            }
        }






    }

    public void inicializarAdaptadorMascotas(){
        MascotasAdapter mascotasAdapter = new MascotasAdapter(mascotasFavoritas, this, true);
        rvListaMascotasFavoritas.setAdapter(mascotasAdapter);
    }


    public void irFavoritos(View v){


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //switch (item.getItemId()) {
          //  case android.R.id.home:
        Intent intent = new Intent(MascotasFavoritas.this, MainActivity.class);


        intent.putExtra("MascotasVO",mascotas);

        startActivity(intent);

       return(super.onOptionsItemSelected(item));
    }

}
