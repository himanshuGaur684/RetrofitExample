package gaur.himanshu.retrofitexample

import android.telecom.Call
import retrofit2.http.GET

interface FeatchData {

    @GET("list")
    fun getCountryList(): retrofit2.Call<List<CountryDetails>> //https://picsum.photos/v2/list
}