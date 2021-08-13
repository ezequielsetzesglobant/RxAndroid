package com.example.rxandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxandroid.R
import com.example.rxandroid.databinding.ItemRecyclerViewBinding
import com.example.rxandroid.domain.entity.DayEntity

class WeatherAdapter(private val dailies: List<DayEntity>, private val onWeatherListener: OnWeatherListener) :
    RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    class WeatherHolder(
        private val binding: ItemRecyclerViewBinding,
        private val context: Context,
        private val onWeatherListener: OnWeatherListener
    ) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(dayEntity: DayEntity) {
            with(binding) {
                textViewItemRecyclerViewDay.text = context.getString(R.string.text_view_day_message_item_recycler_view, dayEntity.dtTxt)
                textViewItemRecyclerViewMinimumTemperature.text =
                    context.getString(R.string.text_view_minimum_temperature_message_item_recycler_view, dayEntity.main.tempMin.toString())
                textViewItemRecyclerViewMaximumTemperature.text =
                    context.getString(R.string.text_view_maximum_temperature_message_item_recycler_view, dayEntity.main.tempMax.toString())
                textViewItemRecyclerViewClouds.text =
                    context.getString(R.string.text_view_clouds_message_item_recycler_view, dayEntity.clouds.all.toString())
                textViewItemRecyclerViewWind.text =
                    context.getString(R.string.text_view_wind_message_item_recycler_view, dayEntity.wind.speed.toString())
                Glide.with(context)
                    .load(context.getString(R.string.image_view_icon_message_item_recycler_view, dayEntity.weather.first().icon))
                    .into(imageViewItemRecyclerViewIcon)
            }
        }

        override fun onClick(v: View?) {
            onWeatherListener.onWeatherClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder =
        WeatherHolder(
            ItemRecyclerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            parent.context,
            onWeatherListener
        )

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(dailies[position])
    }

    override fun getItemCount(): Int = dailies.size

    interface OnWeatherListener {
        fun onWeatherClick(position: Int)
    }
}
