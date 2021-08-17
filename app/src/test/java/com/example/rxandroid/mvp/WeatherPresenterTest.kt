package com.example.rxandroid.mvp

import com.example.rxandroid.adapter.WeatherAdapter
import com.example.rxandroid.data.service.Service
import com.example.rxandroid.domain.entity.CityEntity
import com.example.rxandroid.domain.entity.CoordEntity
import com.example.rxandroid.domain.entity.DayEntity
import com.example.rxandroid.domain.entity.ForecastApiEntity
import com.example.rxandroid.mvp.contract.WeatherContract
import com.example.rxandroid.mvp.model.WeatherModel
import com.example.rxandroid.mvp.presenter.WeatherPresenter
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.rxjava3.android.plugins.RxAndroidPlugins
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.internal.schedulers.ExecutorScheduler
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class WeatherPresenterTest {

    private val forecastApiEntity: ForecastApiEntity = ForecastApiEntity(
        COD,
        MESSAGE,
        CNT,
        LIST,
        CityEntity(ID, NAME, CoordEntity(LAT, LON), COUNTRY, POPULATION, TIMEZONE, SUNRISE, SUNSET)
    )
    private val observableForecastApiEntity: Observable<ForecastApiEntity> = Observable.just(forecastApiEntity)
    private val listener: WeatherAdapter.OnWeatherListener = mock()
    private val weatherService: Service = mock()
    private val view: WeatherContract.WeatherViewContract = mock()
    private val model: WeatherContract.WeatherModelContract = WeatherModel(weatherService)
    private val presenter: WeatherContract.WeatherPresenterContract = WeatherPresenter(model, view)

    @Before
    fun setUp() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun `get weather forecast test`() {
        whenever(weatherService.getObservableForecastApi()).thenReturn(observableForecastApiEntity)

        presenter.getWeatherForecast(listener)

        verify(view).showProgressBar()
        verify(view).showWeatherForecast(forecastApiEntity, listener)
    }

    @Test
    fun `on recycler item clicked test`() {
        presenter.onRecyclerItemClicked(POSITION_ONE)

        verify(view).showExtendedInformation(POSITION_ONE)
    }

    companion object {
        private const val POSITION_ONE: Int = 1

        private const val COD: String = "COD"
        private const val MESSAGE: Int = 1
        private const val CNT: Int = 1
        private val LIST: List<DayEntity> = emptyList()

        private const val ID: Int = 1
        private const val NAME: String = "NAME"
        private const val COUNTRY: String = "COUNTRY"
        private const val POPULATION: Int = 1
        private const val TIMEZONE: Int = 1
        private const val SUNRISE: Int = 1
        private const val SUNSET: Int = 1

        private const val LAT: Double = 1.0
        private const val LON: Double = 1.0

        private const val NO_DELAY: Long = 0

        @BeforeClass
        @JvmStatic
        fun setUpClass() {
            val immediate = object : Scheduler() {

                override fun scheduleDirect(run: Runnable, delay: Long, unit: TimeUnit): Disposable {
                    return super.scheduleDirect(run, NO_DELAY, unit)
                }

                override fun createWorker(): Worker {
                    return ExecutorScheduler.ExecutorWorker({ it.run() }, true, true)
                }
            }
            RxJavaPlugins.setInitIoSchedulerHandler { immediate }
            RxJavaPlugins.setInitComputationSchedulerHandler { immediate }
            RxJavaPlugins.setInitNewThreadSchedulerHandler { immediate }
            RxJavaPlugins.setInitSingleSchedulerHandler { immediate }
            RxAndroidPlugins.setInitMainThreadSchedulerHandler { immediate }
        }
    }
}
