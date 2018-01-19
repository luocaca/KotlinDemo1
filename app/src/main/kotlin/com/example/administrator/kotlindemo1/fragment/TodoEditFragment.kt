package com.example.administrator.kotlindemo1.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.administrator.kotlindemo1.R
import com.example.administrator.kotlindemo1.model.Todo
import io.realm.Realm
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import java.util.*

/**
 *  代办事项  fragment
 */

open class TodoEditFragment : Fragment() {

    /*val   相当于 final  不可变  初始化后不能修改对应的值   单例使用很棒*/
    val realm: Realm = Realm.getDefaultInstance()

    /**新建 一个todo
     * @{} 对象*/

    var todo: Todo? = null

    /*在这个类中有一段包含在companion object中的代码,
    需要说一下的是,Kotlin的class并不支持static变量,
    所以需要使用companion object来声明static变量,
    其实这个platformStatic变量也不是真正的static变量,
    而是一个伴生对象, 这个伴生对象位于Message类中定义的一个
    叫做Companion的内部类中,如图:*/
    companion object {
        var TODO_ID_KEY: String = "todo_id_key"

        fun newInstance(id: String): TodoEditFragment {
            var args: Bundle = Bundle()
            args.putString(TODO_ID_KEY, id)
            var todoEditFragment: TodoEditFragment = newInstance()
            todoEditFragment.arguments = args
            return todoEditFragment
        }


        /*创建一个 fragment */
        private fun newInstance(): TodoEditFragment {
            return TodoEditFragment()
        }

    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        return UI {

            verticalLayout {

                padding = dip(30)
                var title = editText {
                    // editText 视图
                    id = R.id.todo_title
                    hintResource = R.string.app_name
                }

                var content = editText {
                    id = R.id.todo_content
                    height = 400
                    hintResource = R.string.app_name

                }

                button {
                    textResource = R.string.search_menu_title

                    onClick { title.setText(R.string.hellokotlin) }

                    id = R.id.add_todo
                    textColor = Color.WHITE

                    setBackgroundColor(Color.DKGRAY)
                    onClick { _ -> createTodoFrom(title, content) }

                }


            }


        }.view


//        return super.onCreateView(inflater, container, savedInstanceState)
    }


    /**
     * 新增代办事项 ， 存入Realm数据库
     *
     * @param title the title edit text .
     * @param content the content edit text .
     */
    private fun createTodoFrom(title: EditText, content: EditText) {

        realm.beginTransaction()
        //Either update the edited object or create a new one .
        //  UUID是1.5中新增的一个类，在java.util下，用它可以产生一个号称全球唯一的ID。
        var t = todo ?: realm.createObject(Todo::class.java)
//        var t = todo?.id ?: UUID.randomUUID().toString()

        t.id = todo?.id ?: UUID.randomUUID().toString()
        t.title = title.text.toString()
        t.content = content.text.toString()

        realm.commitTransaction()
        activity.supportFragmentManager.popBackStack()
    }


}
