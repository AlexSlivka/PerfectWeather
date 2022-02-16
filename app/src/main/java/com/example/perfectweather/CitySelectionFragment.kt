package com.example.perfectweather

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.perfectweather.databinding.CitySelectionFragmentBinding
import com.example.perfectweather.databinding.MainFragmentBinding

class CitySelectionFragment : Fragment() {

    companion object {
        fun newInstance() = CitySelectionFragment()
    }

    private lateinit var viewModel: CitySelectionViewModel
    private lateinit var binding: CitySelectionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_citySelectionFragment_to_mainFragment)
        }

        return inflater.inflate(R.layout.city_selection_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CitySelectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}