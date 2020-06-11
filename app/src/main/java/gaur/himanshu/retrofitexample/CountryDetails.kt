package gaur.himanshu.retrofitexample

import com.google.gson.annotations.SerializedName

class CountryDetails(

    @SerializedName("author")
    val countryName:String,
    @SerializedName("url")
    val flags:String,
    @SerializedName("download_url")
    val population:String
) {
}