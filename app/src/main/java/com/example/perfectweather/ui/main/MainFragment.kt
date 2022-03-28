package com.example.perfectweather.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.perfectweather.R
import com.example.perfectweather.Util
import com.example.perfectweather.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    /* private val viewModel: MainViewModel by lazy {
         val activity = requireNotNull(this.activity) {
             "You can only access the viewModel after onActivityCreated()"
         }
         ViewModelProvider(this, MainViewModelFactory(activity.application))
             .get(MainViewModel::class.java)
     }*/

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MainFragmentBinding.inflate(inflater, container, false)

        // viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val application = requireNotNull(this.activity).application

        // Create an instance of the ViewModel Factory.
        val viewModelFactory = MainViewModelFactory(application)

        // Get a reference to the ViewModel associated with this fragment.
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.currentWeather.observe(viewLifecycleOwner, Observer { newCur ->

            binding.textView4.text = newCur.toString()
            Glide.with(binding.root)
                .load(Util.convertIconToRDrawable(newCur.iconWeather))
                .into(binding.imageViewMain)
        })

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_citySelectionFragment)
        }

        binding.button2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }

        binding.button5.setOnClickListener { onCorrect() }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //    viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun onCorrect() {

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}