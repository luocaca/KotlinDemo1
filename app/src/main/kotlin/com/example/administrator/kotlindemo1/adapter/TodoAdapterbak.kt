package com.example.administrator.kotlindemo1.adapter

import android.content.Context
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.example.administrator.kotlindemo1.R
import com.example.administrator.kotlindemo1.model.Todo
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmResults
import io.realm.RealmViewHolder

/**
 *   多个构造方法  不能直接继承 （） 无参
 */
class TodoAdapterbak : RealmBasedRecyclerViewAdapter<Todo, TodoAdapterbak.ViewHolder> {

    lateinit var mClick: TodoItemClickListener

    constructor(context: Context, realmResults: RealmResults<Todo>, automaticUpdate: Boolean, s: Boolean, click: TodoItemClickListener)
            : super(context, realmResults, automaticUpdate, s)
    {
        mClick = click
    }


    override fun onCreateRealmViewHolder(p0: ViewGroup?, p1: Int): ViewHolder? {
        return ViewHolder(inflater.inflate(R.layout.fragment_main, null), mClick)
    }

//    override fun onCreateRealmViewHolder(viewGroup: ViewGroup, i: Int): TodoAdapterJavaa.ViewHolder {
//
//        return ViewHolder(inflater.inflate(R.layout.fragment_main, viewGroup))
//    }

    override fun onBindRealmViewHolder(holder: ViewHolder?, pos: Int) {
        holder?.todoTitle?.text = "tv1=$pos"
        holder?.todoContent?.text = "tv2=$pos"
        var todo = realmResults[pos]
        holder?.todoTitle?.text = todo.title
        holder?.todoTitle?.fontFeatureSettings = "font-size:12px"
        holder?.todoTitle?.setTextColor(Color.argb(255, 69, 106, 124))
        holder?.todoContent?.text = todo.content

    }


    inner class ViewHolder(view: View, private val clickListener: TodoItemClickListener?) :
            RealmViewHolder(view), View.OnClickListener {

        // Bind a field to the view for the specified ID. The view will automatically be cast to the field type
        @BindView(R.id.todo_title)
        lateinit var todoTitle: TextView
        // val todoTitle: TextView by bindView(R.id.todo_item_todo_title)
        @BindView(R.id.todo_content)
        lateinit var todoContent: TextView
        // val todoContent: TextView by bindView(R.id.todo_item_todo_content)

        init {
            // Bind annotated fields and methods
            ButterKnife.bind(this, view)
            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            clickListener?.onClick(v, realmResults[adapterPosition])
        }
    }


    interface TodoItemClickListener {
        fun onClick(caller: View, todo: Todo)
    }


}