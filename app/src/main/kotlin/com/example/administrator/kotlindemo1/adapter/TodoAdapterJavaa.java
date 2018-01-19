package com.example.administrator.kotlindemo1.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.kotlindemo1.R;
import com.example.administrator.kotlindemo1.model.Todo;

import co.moonmonkeylabs.realmrecyclerview.LoadMoreListItemView;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

/**
 * Created by Administrator on 2018/1/19 0019.
 */

public class TodoAdapterJavaa extends RealmBasedRecyclerViewAdapter<Todo, TodoAdapterJavaa.ViewHolder> {


    public TodoAdapterJavaa(Context context, RealmResults<Todo> realmResults, boolean automaticUpdate, boolean animateResults, String animateExtraColumnName) {
        super(context, realmResults, automaticUpdate, animateResults, animateExtraColumnName);
    }

    public TodoAdapterJavaa(Context context, RealmResults<Todo> realmResults, boolean automaticUpdate, boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    public TodoAdapterJavaa(Context context, RealmResults<Todo> realmResults, boolean automaticUpdate, boolean animateResults, boolean addSectionHeaders, String headerColumnName) {
        super(context, realmResults, automaticUpdate, animateResults, addSectionHeaders, headerColumnName);
    }

    public TodoAdapterJavaa(Context context, RealmResults<Todo> realmResults, boolean automaticUpdate, boolean animateResults, boolean addSectionHeaders, String headerColumnName, String animateExtraColumnName) {
        super(context, realmResults, automaticUpdate, animateResults, addSectionHeaders, headerColumnName, animateExtraColumnName);
    }

    @Override
    public TodoAdapterJavaa.ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int i) {

        return new ViewHolder(inflater.inflate(R.layout.fragment_main, viewGroup));
    }

    @Override
    public void onBindRealmViewHolder(TodoAdapterJavaa.ViewHolder realmViewHolder, int pos) {
        realmViewHolder.tv1.setText("tv1 = " + pos);
        realmViewHolder.tv1.setText("tv2 = " + pos);
    }


    class ViewHolder extends RealmViewHolder implements TodoItemClickListener {

        public TextView tv1;
        public TextView tv2;

        public ViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.todo_title);
            tv2 = itemView.findViewById(R.id.todo_content);
        }

        public ViewHolder(TextView headerTextView) {
            super(headerTextView);
        }

        public ViewHolder(LoadMoreListItemView loadMoreView) {
            super(loadMoreView);
        }


        @Override
        public void onClick(View view, Todo todo) {

        }
    }

//    RealmViewHolder(view), View.OnClickListener {
//
//        // Bind a field to the view for the specified ID. The view will automatically be cast to the field type
//        @BindView(R.id.todo_item_todo_title)
//        lateinit var todoTitle:
//        TextView
//        // val todoTitle: TextView by bindView(R.id.todo_item_todo_title)
//        @BindView(R.id.todo_item_todo_content)
//        lateinit var todoContent: TextView
//        // val todoContent: TextView by bindView(R.id.todo_item_todo_content)
//
//        init {
//            // Bind annotated fields and methods
//            ButterKnife.bind(this, view)
//            view.setOnClickListener(this)
//        }
//
//        override fun onClick(v: View) {
//            clickListener?.onClick(v, realmResults[adapterPosition])
//        }
//    }


     public interface TodoItemClickListener {
        void onClick(View view, Todo todo);
    }


}
