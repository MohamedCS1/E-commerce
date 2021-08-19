package ui.main

import Data.Client_Product
import Pojo.Product_Model
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsViewModel() :ViewModel() {

    val MutableLiveDataProduct = MutableLiveData<List<Product_Model>>()

    fun start()
    {
        Client_Product().getINSTANSE().get_data().enqueue(object :Callback<List<Product_Model>>
        {
            override fun onResponse(
                call: Call<List<Product_Model>>,
                response: Response<List<Product_Model>>
            ) {

               MutableLiveDataProduct.value = response.body()
            }

            override fun onFailure(call: Call<List<Product_Model>>, t: Throwable) {
               t.message
            }

        })
    }


    fun start_by_categories(category: String)
    {


        Client_Product().getINSTANSE().get_data_by_categories(category).enqueue(object :Callback<List<Product_Model>>
        {

            override fun onResponse(
                call: Call<List<Product_Model>>,
                response: Response<List<Product_Model>>
            ) {

                MutableLiveDataProduct.value = response.body()

            }

            override fun onFailure(call: Call<List<Product_Model>>, t: Throwable) {
                t.message
            }

        })
    }

}