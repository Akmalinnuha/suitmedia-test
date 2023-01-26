package com.akmalinnuha.testsuitmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreen : AppCompatActivity() {
    private lateinit var rvMean: RecyclerView
    private var list: ArrayList<item_data> = arrayListOf()
    private lateinit var Niggadapter: rvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        rvMean = findViewById(R.id.recyclerView)
        Niggadapter = rvAdapter(arrayListOf())
        rvMean.layoutManager = LinearLayoutManager(this)
        getStudents()
        rvMean.adapter = Niggadapter
    }

    fun getStudents(){
        RClient.rService.getStudents().enqueue(object : Callback<item_data> {
            override fun onResponse(call: Call<item_data>, response: Response<item_data>) {
                if( response.isSuccessful ){
                    val data = response.body()
                    if( data != null ){
                        setData(data.data)
                    }
                }
            }

            override fun onFailure(call: Call<item_data>, t: Throwable) {
                Log.d("Error Get", ""+t.stackTraceToString())
            }
        })
    }
    fun setData(data: ArrayList<item_data.Students>){
        Niggadapter.setdata(data)
    }
}