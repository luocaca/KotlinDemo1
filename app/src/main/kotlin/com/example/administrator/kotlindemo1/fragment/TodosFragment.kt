package com.example.administrator.kotlindemo1.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import butterknife.ButterKnife
import com.example.administrator.kotlindemo1.R
import com.example.administrator.kotlindemo1.adapter.TodoAdapterbak
import com.example.administrator.kotlindemo1.http.RequestWrapper
import com.example.administrator.kotlindemo1.model.Todo
import io.realm.Realm
import kotlinx.android.synthetic.main.fragment_todos.*
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject

/**
 *   todo fragment
 *
 *
 *   kotlin 入门网址
 *   学习奇淫技巧qz
 *
 *
 *   http://www.kotlindoc.cn/chapter/chapter13_kotlin_android.html
 */

class TodosFragment : Fragment(), TodoAdapterbak.TodoItemClickListener {

//    @BindView(R.id.todos_recycler_view)
//    lateinit var realmRecycleView: RealmRecyclerView

    private val realm: Realm = Realm.getDefaultInstance()


    var http: RequestWrapper? = null;


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view: View? = inflater?.inflate(R.layout.fragment_todos, null)
        ButterKnife.bind(view!!)
        return view

    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var json = JSONObject()

        val postBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString())

        http = RequestWrapper()

        http!!.http {
            timeout = 1000

            url = "http://www.luocaca.cn/hello-ssm/book/allbook"

            method = "get"

            onSuccess {

                json: String ->
                Log.i("get json ", "json=\n" + json)

            }
            onFaild { e ->
                Log.i("error", "json=\n" + e.message)
            }

        }


    }


    override fun onClick(caller: View, todo: Todo) {
        val todoFragment = TodoEditFragment.newInstance(todo.id)
        activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.content_main, todoFragment, todoFragment.javaClass.simpleName)
                .addToBackStack(todoFragment.javaClass.simpleName)
                .commit()
    }


    private fun createTodoFrom(title: EditText, todoContent: EditText) {
        realm?.beginTransaction()

    }


    override fun onResume() {
        super.onResume()
        val todos = realm!!.where(Todo::class.java).findAll()
        Log.i(tag, "onResume: ${todos}")
        Log.i(tag, "onResume: realmRecyclerView = ${todos_recycler_view} ")
        val adapter = TodoAdapterbak(activity, todos, true, true, this)
        todos_recycler_view.setAdapter(adapter)
    }


}