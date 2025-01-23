package com.example.miprimerreciclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.miprimerreciclerview.databinding.ElementoRecyclerBinding

class AdaptadorRecycler(private val datos:List<Coche>,val onClick_item:(Int)->Unit):RecyclerView.Adapter<AdaptadorRecycler.MiViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {

        //Inflar la vista de un elemento
        val vista=LayoutInflater.from(parent.context).inflate(R.layout.elemento_recycler,parent,false)
        //Construyo un objeto ViewHolder, de mi propia clase
        val objeto_viewholder=MiViewHolder(vista)
        //Retorno el objeto creado
        return objeto_viewholder

    }
    override fun getItemCount(): Int {
            return datos.size
    }
    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        //Vinculo cada una de los elementos visuales (vistas)
        //del holder con los datos
            holder.render(datos.get(position),position)
           holder.itemView.setOnClickListener { //seinvoca a algo que viene de fuera
                onClick_item(position)
            }


    }
    //Clase que representa un ViewHolder
    class MiViewHolder( val vista:View):RecyclerView.ViewHolder(vista)
    {
        //Hacemos el binding dentro del holder
        private var binding_holder=ElementoRecyclerBinding.bind(vista)

        //La propiedad itemview representa la vista individual y
        //tiene la misma referencia que vista
            fun render(dato:Coche,pos:Int)
            {
                binding_holder.textView.text=dato.marca
                if(dato.seleccionado)
                {
                    vista.setBackgroundColor( vista.context.getColor(R.color.gris) )
                }
                else
                {
                    vista.setBackgroundColor( vista.context.getColor(R.color.white) )
                }


            }
    }
}