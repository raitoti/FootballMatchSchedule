package divascion.marfiandhi.footballmatchschedule.model

import java.net.URL

/**
 * Created by Marfiandhi on 9/12/2018.
 */
class ApiRepository {

    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}