package gaur.himanshu.retrofitexample

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
https://restcountries.eu/rest/v2/all
 */


class MainActivity : AppCompatActivity() {

    var list = listOf<CountryDetails>()
    val countryAdapter = CountryAdapter(this@MainActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Main).launch {
           featchData()

        }




    }


    private fun featchData() {
        val retrofit = Retrofit.Builder().baseUrl("https://picsum.photos/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val featch = retrofit.create(FeatchData::class.java)
        val call = featch.getCountryList()
        call.enqueue(object : Callback<List<CountryDetails>> {
            override fun onFailure(call: Call<List<CountryDetails>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Failed", Toast.LENGTH_LONG).show()
                t!!.printStackTrace()
            }

            override fun onResponse(
                call: Call<List<CountryDetails>>?,
                response: Response<List<CountryDetails>>?
            ) {
                Log.i("Result", Gson().toJson(response!!.body().toString()))
                list = response!!.body()
                countryAdapter.setContentList(list)
                countryAdapter.notifyDataSetChanged()
                recycler.adapter = countryAdapter
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_LONG).show()


            }

        })


    }

    private fun setRecyclerView(list: List<CountryDetails>) {

    }
}