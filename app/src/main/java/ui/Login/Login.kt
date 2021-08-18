package ui.Login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.ecommerce.R
import ui.main.MainActivity

class Login : AppCompatActivity() {

    var logo:ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val bu_skip = findViewById<TextView>(R.id.tv_skip)

        bu_skip.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


}