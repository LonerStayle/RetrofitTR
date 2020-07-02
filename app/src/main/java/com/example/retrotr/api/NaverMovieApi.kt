package com.example.retrotr.api


import android.view.Display
import com.example.retrotr.api.dataholder.NaverMovieSearchResult
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

object NaverApiClient{
    private const val BASE_URL= " https://openapi.naver.com/"
    val api: NaverMovieApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NaverMovieApi::class.java)
}


interface NaverMovieApi{
    @Headers(
        "X-Naver-Client-Id:byZrzxTCE0tATR4C2j7n",
        "X-Naver-Client-Secret:73PV_qyBCq"
    )

    @GET("v1/search/movie")
    suspend fun seachMovie(
        @Query("query",encoded = true) query: String,
        @Query("display") display:Int = 100
    ):NaverMovieSearchResult
}


