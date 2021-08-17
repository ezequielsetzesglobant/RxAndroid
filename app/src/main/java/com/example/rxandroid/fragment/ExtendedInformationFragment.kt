package com.example.rxandroid.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.rxandroid.R
import com.example.rxandroid.databinding.FragmentExtendedInformationBinding
import com.example.rxandroid.domain.entity.DayEntity
import com.example.rxandroid.mvp.contract.ExtendedInformationContract
import com.example.rxandroid.mvp.presenter.ExtendedInformationPresenter
import com.example.rxandroid.mvp.view.ExtendedInformationView
import java.io.Serializable

class ExtendedInformationFragment : DialogFragment() {

    private lateinit var binding: FragmentExtendedInformationBinding
    private lateinit var presenter: ExtendedInformationContract.ExtendedInformationPresenterContract

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentExtendedInformationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ExtendedInformationPresenter(ExtendedInformationView(this, binding))
        arguments?.let { bundle ->
            val dayEntity = bundle.getSerializable(DAY_ENTITY_KEY) as? DayEntity
            with(binding) {
                buttonFragmentClose.setOnClickListener { presenter.onCloseClicked() }
                dayEntity?.let { day ->
                    textViewFragmentWeatherMain.text =
                        context?.getString(R.string.text_view_weather_main_message_fragment, day.weather.first().main)
                    textViewFragmentHumidity.text =
                        context?.getString(R.string.text_view_humidity_message_fragment, day.main.humidity.toString())
                    textViewFragmentVisibility.text =
                        context?.getString(R.string.text_view_visibility_message_fragment, day.visibility.toString())
                    textViewFragmentWeatherDescription.text =
                        context?.getString(R.string.text_view_weather_description_message_fragment, day.weather.first().description)
                }
            }
        }
    }

    companion object {
        private const val DAY_ENTITY_KEY = "DAY_ENTITY_KEY"

        fun newInstance(dayEntity: DayEntity): ExtendedInformationFragment = ExtendedInformationFragment().apply {
            arguments = Bundle().apply {
                putSerializable(DAY_ENTITY_KEY, dayEntity as? Serializable)
            }
        }
    }
}
