package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.lifecycle.LiveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiiliohjelmointiprojekti.database.Arvostelu
import com.example.mobiiliohjelmointiprojekti.database.ArvosteluDao
import com.example.mobiiliohjelmointiprojekti.databinding.FragmentArvosteluikkunaBinding
import kotlinx.android.synthetic.main.custom_row.view.*


class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var arvosteluList = emptyList<Arvostelu>()



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row,parent,false)



        return(MyViewHolder(view))
    }

    override fun getItemCount(): Int {
        return  arvosteluList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = arvosteluList[position]
        holder.itemView.arvosteluid.text = currentItem.arvosteluid.toString()
        holder.itemView.arvosteluotsikko.text = currentItem.otsikko
        //holder.itemView.arvosteluteksti.text = currentItem.teksti
        //holder.itemView.arvostelunumero.text = currentItem.arvosana.toString()

        holder.itemView.rowLayout.setOnClickListener{
            val action = ArvosteluikkunaDirections.actionArvosteluikkunaToKatsoArvostelua(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    fun setData(arvostelu: List<Arvostelu>){
        this.arvosteluList = arvostelu
        notifyDataSetChanged()
    }

}

