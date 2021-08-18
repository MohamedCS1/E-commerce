package Data

import Pojo.Product_Model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class Client_Product {

    var BaseURL:String = "https://fakestoreapi.com"
    var productInterface:Product_Interface? = null
    var INSTANSE:Client_Product? = null

    constructor()
    {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        productInterface = retrofit.create(Product_Interface::class.java)

    }

    @JvmName("getINSTANSE1")
    fun getINSTANSE():Client_Product
    {
        if (null == INSTANSE)
        {
            INSTANSE = Client_Product()
        }

        return INSTANSE!!
   }

    fun get_data():Call<List<Product_Model>>
    {

        return productInterface!!.get_Products()

    }

    fun get_data_by_categories(category: String):Call<List<Product_Model>>
    {
        return productInterface!!.get_Products_by_categories(category)
    }

}