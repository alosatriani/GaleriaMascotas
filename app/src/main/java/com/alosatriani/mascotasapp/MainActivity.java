package com.alosatriani.mascotasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.alosatriani.mascotasapp.adaptador.MascotasAdapter;
import com.alosatriani.mascotasapp.vo.MascotasVO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ArrayList<MascotasVO> mascotas;
    private RecyclerView rvListaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Activamos el ToolBar
        Toolbar miActionBar = (Toolbar) findViewById(R.id.actionBar);
        setSupportActionBar(miActionBar);

        rvListaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(this);

        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas(savedInstanceState);

        inicializarAdaptadorMascotas();


    }


    public void inicializarListaMascotas(Bundle bdl){



        // bdl = intent.getExtras();
        ArrayList<MascotasVO> listaMascotas = null;
        try{
            listaMascotas = (ArrayList<MascotasVO> ) bdl.getSerializable("MascotasVO");

        }catch(Exception e){

        }

        if(listaMascotas == null) {


            mascotas = new ArrayList<MascotasVO>();


           // mascotas.add(new MascotasVO("Pelusa", R.drawable.pelusa));
            mascotas.add(new MascotasVO("Bombón", R.drawable.dogtowel));
           // mascotas.add(new MascotasVO("Frida", R.drawable.frida));
            mascotas.add(new MascotasVO("Kika", R.drawable.dog4));
           // mascotas.add(new MascotasVO("Bombón", R.drawable.enzo));

            mascotas.add(new MascotasVO("Bola", R.drawable.dog5));
           // mascotas.add(new MascotasVO("Bombón", R.drawable.karin));

            mascotas.add(new MascotasVO("Roosky", R.drawable.dog6));
          //  mascotas.add(new MascotasVO("Bombón", R.drawable.kika));

            mascotas.add(new MascotasVO("Roberto", R.drawable.dog7));
           // mascotas.add(new MascotasVO("Bombón", R.drawable.dodo));
            mascotas.add(new MascotasVO("Huesos", R.drawable.dogpug));

            //mascotas.add(new MascotasVO("Bombón", R.drawable.niko));
            mascotas.add(new MascotasVO("Enzo", R.drawable.dog2));
            //mascotas.add(new MascotasVO("Bombón", R.drawable.luna));


        } else{
            mascotas = listaMascotas;
        }


    }

    public void inicializarAdaptadorMascotas(){
        MascotasAdapter mascotasAdapter = new MascotasAdapter(mascotas, this, false);
        rvListaMascotas.setAdapter(mascotasAdapter);
    }

    public void irFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);


        intent.putExtra("MascotasVO",mascotas);

        startActivity(intent);


    }

}
