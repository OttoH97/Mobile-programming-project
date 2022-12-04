package com.example.mobiiliohjelmointiprojekti

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobiiliohjelmointiprojekti.database.ArvosteluViewModel
import kotlinx.android.synthetic.main.fragment_arvosteluikkuna.view.*

class Arvosteluikkuna : Fragment() {

    private lateinit var mArvosteluViewModel: ArvosteluViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_arvosteluikkuna, container, false)

        //RecyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerArvostelu
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //ArvosteluViewModel
        mArvosteluViewModel = ViewModelProvider(this).get(ArvosteluViewModel::class.java)
        mArvosteluViewModel.arvostelut.observe(viewLifecycleOwner, Observer { arvostelu ->
            adapter.setData(arvostelu)
        })

        val btnTolisaaArvostelu = view.findViewById<Button>(R.id.btnToLisaaArvostelu)

        btnTolisaaArvostelu.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_arvosteluikkuna_to_lisaaArvostelu)
        }

        return view
    }

}