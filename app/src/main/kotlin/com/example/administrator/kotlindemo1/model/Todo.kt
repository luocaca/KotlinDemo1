package com.example.administrator.kotlindemo1.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

/**
 *  to do model for kotlin
 */

@RealmClass
open class Todo : RealmObject() {

    @PrimaryKey
    open var id: String = "-1"
    open var title: String = "日程"
    open var content: String = "事项"








}