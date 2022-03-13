package com.example.perfectweather.ui

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
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = MainFragmentBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        /** Setting up LiveData observation relationship **/
        viewModel.word.observe(viewLifecycleOwner, Observer { newWord ->
            binding.textView.text = newWord
        })

        viewModel.imageWeb.observe(viewLifecycleOwner, Observer { newImg ->

           binding.textViewImg.text = newImg

            //val imgUri = "http://openweathermap.org/img/wn/10d@2x.png".toUri()

            Glide.with(binding.root)
                .load(Util.convertIconToRDrawable(newImg))
                .into(binding.imageViewMain)

            // val  resim = "R.drawable.icon_" + "01d"

            // binding.imageViewMain.setImageResource(R.drawable.icon_ + 01d)

        })

        viewModel.currentWeather.observe(viewLifecycleOwner, Observer { newCur ->

            binding.textView4.text = newCur.toString()


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
        viewModel.onCorrect()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}