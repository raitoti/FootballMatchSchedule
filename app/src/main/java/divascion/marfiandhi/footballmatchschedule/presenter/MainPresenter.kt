package divascion.marfiandhi.footballmatchschedule.presenter

import com.google.gson.Gson
import divascion.marfiandhi.footballmatchschedule.model.ApiRepository
import divascion.marfiandhi.footballmatchschedule.model.events.ScheduleResponse
import divascion.marfiandhi.footballmatchschedule.model.events.TheSportDBApi
import divascion.marfiandhi.footballmatchschedule.view.MainView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Marfiandhi on 9/12/2018.
 */
class MainPresenter(private val view: MainView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {
    fun getSchedule(event: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .doRequest(TheSportDBApi.getSchedule(event)),
                    ScheduleResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.showSchedule(data.events)
            }
        }
    }
}