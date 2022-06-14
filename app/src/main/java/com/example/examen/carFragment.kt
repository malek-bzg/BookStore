package com.example.examen


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class carFragment : Fragment() {
    lateinit var recylcerChampionAdapter: carAdapter
    lateinit var carRecyclerView: RecyclerView
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val rootView = inflater.inflate(R.layout.fragment_car, container, false)

        var champList : MutableList<Champion> = ArrayList()


        carRecyclerView = rootView.findViewById(R.id.recycler_champ)



        champList.add(Champion(id=0 ,champPic = R.drawable.ic_book1, Nom = "kia picanto", dispo = "DISPONIBLE",prix = 120))
        champList.add(Champion(id=2 ,champPic = R.drawable.ic_book2, Nom = "kia_rio", dispo = "DISPONIBLE",prix = 1250 ))
        champList.add(Champion(id= 3,champPic = R.drawable.ic_book3, Nom = "polo8", dispo = "DISPONIBLE",prix = 412440 ))
        champList.add(Champion(id= 4,champPic = R.drawable.ic_book4, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 519620 ))
        champList.add(Champion(id= 5,champPic = R.drawable.ic_book5, Nom = "seat_ibiza", dispo = "DISPONIBLE",prix = 91066 ))
        champList.add(Champion(id= 6,champPic = R.drawable.ic_book6, Nom = "renault_symbol", dispo = "DISPONIBLE",prix = 61033 ))
        recylcerChampionAdapter = carAdapter(champList)
        carRecyclerView.adapter = recylcerChampionAdapter

        carRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL ,
            false)


        return rootView
    }

}