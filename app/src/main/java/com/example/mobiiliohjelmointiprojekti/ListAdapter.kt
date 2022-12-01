package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobiiliohjelmointiprojekti.database.Arvostelu
import com.example.mobiiliohjelmointiprojekti.databinding.FragmentArvosteluikkunaBinding


/*class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var _binding: FragmentArvosteluikkunaBinding? = null
    private val binding get() = _binding!!
    private var arvosteluList = emptyList<Arvostelu>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun OnCreateViewHolder(inflater: LayoutInflater,container : ViewGroup?,savedInstanceState: Bundle?) : MyViewHolder {
        //return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent,false))
        FragmentArvosteluikkunaBinding.inflate(inflater,container,false)

        binding.btnToLisaaArvostelu



    }

    override fun getItemCount(): Int {
        return  arvosteluList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = arvosteluList[position]
        holder.itemView.id

    }
}

 */