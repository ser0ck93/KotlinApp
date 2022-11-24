package com.example.prueba

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

private var _binding: FragmentHomeBinding? = null
private val binding: FragmentHomeBinding get()=_binding!!
private lateinit var serviceAdapter:ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onStart(){
        super.onStart()
        serviceAdapter = ServiceAdapter(listOf(
            ServiceitemModel(
                "1","General", "Los mejores especialistas en medicina", R.drawable.cruz.toString()
            ),
            ServiceitemModel(
                "2","Especialista", "Los mejores medicos especialistas", R.drawable.doc.toString()
            ),
            ServiceitemModel(
                "3","Dermatologia", "Los mejores especialistas en Dermatologia", R.drawable.cura.toString()
            ),
            ServiceitemModel(
                "4","Odontologia", "Los mejores especialistas en Odontologia", R.drawable.diente.toString()
            )
        ))
        serviceAdapter.listener= object : OnServiceClickListener{
            override fun onClick(item: ServiceitemModel) {
                val direction = HomeFragmentDirections.actionHomeFragmentToSpecialistFragment()
                direction.name = item.title
                direction.description = item.description
                direction.search = false
               findNavController().navigate(direction)
            }

        }

        binding.homeFragmentRecycler.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


    }
}