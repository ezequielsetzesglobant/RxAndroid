package com.example.rxandroid.mvp.view

import android.app.Activity
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rxandroid.adapter.WeatherAdapter
import com.example.rxandroid.databinding.ActivityWeatherBinding
import com.example.rxandroid.domain.entity.DayEntity
import com.example.rxandroid.domain.entity.ForecastApiEntity
import com.example.rxandroid.fragment.ExtendedInformationFragment
import com.example.rxandroid.mvp.contract.WeatherContract
import com.example.rxandroid.mvp.view.base.ActivityView

class WeatherView(activity: Activity, private val binding: ActivityWeatherBinding) : ActivityView(activity),
    WeatherContract.WeatherViewContract {

    private var forecastApiEntityList: List<DayEntity> = emptyList()

    override fun showWeatherForecast(forecastApiEntity: ForecastApiEntity, onWeatherListener: WeatherAdapter.OnWeatherListener) {
        forecastApiEntityList = forecastApiEntity.list
        binding.recyclerViewDailiesRecyclerActivityList.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewDailiesRecyclerActivityList.adapter = WeatherAdapter(forecastApiEntity.list, onWeatherListener)
        binding.progressBarWeatherActivityDataLoad.visibility = View.GONE
    }

    override fun showExtendedInformation(position: Int) {
        fragmentManager?.let {
            ExtendedInformationFragment.newInstance(forecastApiEntityList[position]).apply {
                show(it, TAG)
                isCancelable = false
            }
        }
    }

    override fun showProgressBar() {
        binding.progressBarWeatherActivityDataLoad.visibility = View.VISIBLE
    }

    companion object {
        private const val TAG: String = "EXTENDED_INFORMATION_FRAGMENT"
    }
}
