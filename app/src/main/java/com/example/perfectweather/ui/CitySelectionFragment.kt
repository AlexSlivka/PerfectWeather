package com.example.perfectweather.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.perfectweather.R
import com.example.perfectweather.databinding.CitySelectionFragmentBinding

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
        binding = DataBindingUtil.inflate(
            inflater, R.layout.city_selection_fragment, container, false
        )

        binding.button3.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_citySelectionFragment_to_mainFragment)
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CitySelectionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}