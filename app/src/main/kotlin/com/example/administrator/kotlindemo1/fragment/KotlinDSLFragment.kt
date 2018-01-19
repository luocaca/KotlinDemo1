package com.example.administrator.kotlindemo1.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.administrator.kotlindemo1.R
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI

/**
 *  kotlin dsl 代码布局 使用案例
 */

class KotlinDSLFragment : Fragment() {


    companion object {

        public fun newInstance(): KotlinDSLFragment {
            return KotlinDSLFragment()
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {

            verticalLayout {

                padding = dip(30)

                var btn = button {
                    text = "this is a button"
                    textColor = R.color.design_fab_stroke_top_inner_color
                }


                var txt = textView {
                    hintResource = R.string.app_name
                    padding = dip(8)
                    onClick {
                        activity.supportFragmentManager.popBackStack()
                    }
                }
            }
        }.view
    }


}
