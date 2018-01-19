package com.example.administrator.kotlindemo1

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import com.example.administrator.kotlindemo1.fragment.KotlinDSLFragment
import com.example.administrator.kotlindemo1.fragment.TodoEditFragment
import com.example.administrator.kotlindemo1.fragment.TodosFragment
import kotlinx.android.synthetic.main.activity_main1.*
import org.jetbrains.anko.onClick


/**
 * kotlin 入门网址
 * http://www.kotlindoc.cn/chapter/chapter13_kotlin_android.html
 * 学习奇淫技巧qz
 */
class MainActivity1 : AppCompatActivity() {


    /*其中，lateinit 修饰符允许声明非空类型，并在对象创建后(构造函数调用后)初始化。
     不使用 lateinit 则需要声明可空类型并且有额外的空安全检测操作。*/
    @BindView(R.id.message)
    lateinit var msg: TextView

    val tag = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*设置toolbar*/





        setContentView(R.layout.activity_main1)


        var todosFragment = TodosFragment()
        supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.content_main, todosFragment, todosFragment.javaClass.simpleName)
                .addToBackStack(todosFragment.javaClass.simpleName)
                .commit()

        fragment_fab?.setOnClickListener {
            var todoEditFragment = TodoEditFragment()
            supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.content_main, todoEditFragment, todoEditFragment.javaClass.simpleName)
                    .addToBackStack(todoEditFragment.javaClass.simpleName)
                    .commit()
        }


        dsl?.onClick {
            var dslFragment = KotlinDSLFragment.newInstance()
            supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(R.id.content_main, dslFragment, dslFragment.javaClass.simpleName)
                    .addToBackStack(dslFragment.javaClass.simpleName)
                    .commit()
        }


        //content_main
    }


}
