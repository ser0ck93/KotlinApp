package com.example.prueba

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val specialists= listOf(
            DoctorItemModel("1","Dr. Sebastian Toro","Odontologia","+300",R.drawable.doc.toString(),4,"el mejor en lo que hace")
        )
        if(args.search){
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.VISIBLE
            binding.specialistFragmentRecyclerTitle.visibility = View.GONE
            binding.specialistFragmentRecyclerTitle.text = getString(R.string.specialist_title)
            binding.specialistFragmentSubtitle.text = getString(R.string.specialist_subtitle)
            doctorAdapter.updateDataset(specialists)
        }else{
            binding.specialistFragmentRecyclerSearchLayout.visibility = View.GONE
            binding.specialistFragmentRecyclerSearch.visibility = View.VISIBLE
            binding.specialistFragmentTitle.text = args.name
            binding.specialistFragmentSubtitle.text = args.description
            doctorAdapter.updateDataset(specialists.filter { it.speciality == args.name })

        }
    }
}