package com.example.administrator.kotlindemo1

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick

class MainActivity : AppCompatActivity() {


    /*其中，lateinit 修饰符允许声明非空类型，并在对象创建后(构造函数调用后)初始化。
     不使用 lateinit 则需要声明可空类型并且有额外的空安全检测操作。*/
    @BindView(R.id.message)
    lateinit var msg: TextView

    val tag = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*设置toolbar*/

        setContentView(R.layout.activity_main)
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        setSupportActionBar(main_toolbar)
//        actionBar.setDisplayHomeAsUpEnabled(true)
        main_toolbar.setLogo(R.mipmap.ic_launcher)

        ButterKnife.bind(this)

        toggleButton.text = getString(R.string.hellokotlin)


        message.text = "i am message from kotlin"


        message.setOnClickListener({ toast("hello world") })


        findViewById<TextView>(R.id.message).append("\n i am from findbyid")


        main_bottom.text = "main bottom button"


        msg.append("\n i am from buttfinl")


        main_bottom.onClick { v -> v?.let { hidenView(it, View.GONE) } }

//        hidenView(main_bottom, View.GONE )


        main_fab.onClick {
            Snackbar.make(main_fab, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

            jump();


        }

//        main_fab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }


        for (a in 10..20) {
            Log.i(tag, "=====================" + a)
        }


        initTodo()


    }


    private fun initTodo() {

        main_input1.text
        main_input2.text
        main_submit.onClick {
            toast("标题 = ${main_input1.text}  \n代办内容 =    ${main_input2.text}")
        }


    }


    fun hidenView(view: View, visizbley: Int) {
        view.visibility = visizbley
    }

//    public void hidenView()
//    {
//
//    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }


    private fun AppCompatActivity.toast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.menu1) {
            toast("menu1")
            return true
        }
        if (id == R.id.menu2) {
            toast("menu2")
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    /**
     * 跳转到mainactivityu 1
     */
    private fun jump() {
        startActivity(Intent(this, MainActivity1::class.java))
    }


}
