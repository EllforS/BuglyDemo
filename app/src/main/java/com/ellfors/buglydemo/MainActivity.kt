package com.ellfors.buglydemo

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init()
    {
        tv_main.text = "3.0.0 第一次 修改"
        tv_main.setTextColor(Color.GREEN)

        btn_main.setOnClickListener {
            Toast.makeText(this@MainActivity, "啊啊啊啊啊", Toast.LENGTH_SHORT).show()
        }
    }

}
