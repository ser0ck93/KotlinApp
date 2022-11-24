package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba.databinding.FragmentLocationBinding
import com.example.prueba.databinding.FragmentSpecialistBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SpecialistFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpecialistFragment : Fragment() {

    private var _binding: FragmentSpecialistBinding?= null
    private val binding: FragmentSpecialistBinding get() = _binding!!
    private val args: SpecialistFragmentArgs by navArgs()
    private lateinit var doctorAdapter: DoctorAdapter
    private lateinit var categories: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentSpecialistBinding.inflate(layoutInflater,container,false)
        return binding.root

    }


    override fun onStart() {
        super.onStart()
        doctorAdapter = DoctorAdapter(listOf())
        binding.homeFragmentRecycler.apply {
            adapter=doctorAdapter
            layoutManager=LinearLayoutManager(requireContext())
        }

        val services = listOf(
            ServiceitemModel( "1","General","los mejores especialistas en medicina general",R.drawable.cruz.toString()),
            ServiceitemModel( "1","Especialista","los mejores especialistas",R.drawable.cruz.toString()),
            ServiceitemModel( "1","Dermatologia","los mejores especialistas en Dermatologia",R.drawable.cura.toString()),
            ServiceitemModel( "1","Odontologia","los mejores especialistas en Odontologia",R.drawable.diente.toString())
        )
        categories=services.map{it.title}.toMutableList()
        categories.add(0,"Todos")

        val specialists = listOf(
            DoctorItemModel("1","Dr. Sebastian Toro","Odontologia","+100",R.drawable.doc.toString(),2,"el mejor en lo que hace"),
            DoctorItemModel("1","Dr. Manuel Camargo","General","+200",R.drawable.doc.toString(),2,"el mejor en lo que hace"),
            DoctorItemModel("1","Dra. Nayive Chiappe","Especialista","+300",R.drawable.doc.toString(),1,"el mejor en lo que hace"),
            DoctorItemModel("1","Dra. Yireth Fonseca","Odontologia","+250",R.drawable.doc.toString(),3,"el mejor en lo que hace"),
            DoctorItemModel("1","Dr. Nelson Cipa","General","+180",R.drawable.doc.toString(),2,"el mejor en lo que hace"),
            DoctorItemModel("1","Dr. Sebastian castro","Dermatologia","+350",R.drawable.doc.toString(),1,"el mejor en lo que hace"
        )
        )


        if(args.search){
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
            binding.specialistFragmentRecyclerTitle.visibility = View.GONE
            binding.specialistFragmentRecyclerTitle.text = getString(R.string.specialist_title)
            binding.specialistFragmentSubtitle.text = getString(R.string.specialist_subtitle)
            doctorAdapter.updateDataset(specialists)
            binding.specialistFragmentRecyclerSearch.setAdapter(ArrayAdapter(requireContext(),android.R.layout.simple_dropdown_item_1line,categories))
            binding.specialistFragmentRecyclerSearch.setOnItemClickListener { parent, view, position, id ->
                if(position==0){
                    doctorAdapter.updateDataset(specialists)
                }else{
                val category = categories[position]
                doctorAdapter.updateDataset(specialists.filter { it.speciality == category })
            }}
        }else{
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.GONE
            binding.specialistFragmentRecyclerSearch.visibility = View.VISIBLE
            binding.specialistFragmentTitle.text = args.name
            binding.specialistFragmentSubtitle.text = args.description
            doctorAdapter.updateDataset(specialists.filter { it.speciality == args.name })

        }
    }
}