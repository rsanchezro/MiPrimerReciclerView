package com.example.miprimerreciclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimerreciclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mibinding:ActivityMainBinding
    //Definimos objeto del RecyclerView
    lateinit var mirecycler:RecyclerView
    //Defino un objeto del Adapter
    lateinit var miadapter:AdaptadorRecycler
    //Creo la lista de datos
    var lista_datos= mutableListOf("Mercedes","Bmw","Renault","Opel","Ford")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //BINDING
        mibinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(mibinding.root)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializar_recyclerView()

    }

    private fun inicializar_recyclerView() {
        //Instancio el recyclerview
        this.mirecycler=mibinding.viewMirecycler

        //4ºPaso definir manejador del Layout del recycler
        this.mirecycler.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        //Asignar una referencia del adaptador
        this.miadapter=AdaptadorRecycler(this.lista_datos)

        //Vinculo al recycler view el adaptador
        this.mirecycler.adapter=this.miadapter
        

    }
}