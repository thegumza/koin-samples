package fr.ekito.myweatherapp.view.weather.list

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.joanzapata.iconify.widget.IconTextView
import fr.ekito.myweatherapp.R
import fr.ekito.myweatherapp.domain.entity.getColorFromCode

class WeatherListAdapter(
    val context: Context,
    var list: List<WeatherItem>,
    private val onDetailSelected: (WeatherItem) -> Unit
) : androidx.recyclerview.widget.RecyclerView.Adapter<WeatherListAdapter.WeatherResultHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherResultHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather, parent, false)
        return WeatherResultHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherResultHolder, position: Int) {
        holder.display(list[position], context, onDetailSelected)
    }

    override fun getItemCount() = list.size

    inner class WeatherResultHolder(item: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(item) {
        private val weatherItemLayout = item.findViewById<LinearLayout>(R.id.weatherItemLayout)
        private val weatherItemDay = item.findViewById<TextView>(R.id.weatheItemrDay)
        private val weatherItemIcon = item.findViewById<IconTextView>(R.id.weatherItemIcon)

        fun display(
            dailyForecastModel: WeatherItem,
            context: Context,
            onClick: (WeatherItem) -> Unit
        ) {
            weatherItemLayout.setOnClickListener { onClick(dailyForecastModel) }
            weatherItemDay.text = dailyForecastModel.day
            weatherItemIcon.text = dailyForecastModel.icon
            val color = context.getColorFromCode(dailyForecastModel)
            weatherItemDay.setTextColor(color)
            weatherItemIcon.setTextColor(color)
        }

    }
}