package com.example.administrator.kotlindemo1.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.moonmonkeylabs.realmrecyclerview.LoadMoreListItemView
import com.example.administrator.kotlindemo1.model.Todo
import io.realm.RealmBasedRecyclerViewAdapter
import io.realm.RealmResults
import io.realm.RealmViewHolder

/**
 *  it is a adapter
 */

class TodoAdapterJava : RealmBasedRecyclerViewAdapter<Todo, RealmViewHolder> {


    constructor(context: Context, realmResults: RealmResults<Todo>, automaticUpdate: Boolean, animateResults: Boolean, animateExtraColumnName: String) : super(context, realmResults, automaticUpdate, animateResults, animateExtraColumnName) {}

    constructor(context: Context, realmResults: RealmResults<Todo>, automaticUpdate: Boolean, animateResults: Boolean)
            : super(context, realmResults, automaticUpdate, animateResults) {}

    constructor(context: Context, realmResults: RealmResults<Todo>, automaticUpdate: Boolean, animateResults: Boolean, addSectionHeaders: Boolean, headerColumnName: String) : super(context, realmResults, automaticUpdate, animateResults, addSectionHeaders, headerColumnName) {}

    constructor(context: Context, realmResults: RealmResults<Todo>, automaticUpdate: Boolean, animateResults: Boolean, addSectionHeaders: Boolean, headerColumnName: String, animateExtraColumnName: String) : super(context, realmResults, automaticUpdate, animateResults, addSectionHeaders, headerColumnName, animateExtraColumnName) {}

    override fun onCreateRealmViewHolder(viewGroup: ViewGroup, i: Int): RealmViewHolder? {
        return null
    }

    override fun onBindRealmViewHolder(realmViewHolder: RealmViewHolder, i: Int) {

    }


    internal inner class ViewHolder : RealmViewHolder, TodoItemClickListener {

        var tv1: TextView? = null
        var tv2: TextView? = null

        constructor(itemView: View) : super(itemView) {

        }

        constructor(headerTextView: TextView) : super(headerTextView) {}

        constructor(loadMoreView: LoadMoreListItemView) : super(loadMoreView) {}


        override fun onClick(view: View, todo: Todo) {

        }
    }

    internal interface TodoItemClickListener {
        fun onClick(view: View, todo: Todo)
    }

}
