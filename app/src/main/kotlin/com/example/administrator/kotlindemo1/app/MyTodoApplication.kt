package com.example.administrator.kotlindemo1.app

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 *  my app
 */

class MyTodoApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        val config = RealmConfiguration.Builder(this)
                .name("realm.my_todos")//库文件名
                .encryptionKey(getKey())//加密
                .schemaVersion(1)//版本号
                .deleteRealmIfMigrationNeeded()
                .build()
        /**
         * RealmConfiguration.Builder里面如果没有deleteRealmIfMigrationNeeded()的话，会如下报错误：

        Caused by: io.realm.exceptions.RealmMigrationNeededException:
        RealmMigration must be provided ...
        at com.easy.kotlin.mytodoapplication.TodoListFragment.onActivityCreated(TodoListFragment.kt:36)
         */


        Realm.setDefaultConfiguration(config) // 设置默认 RealmConfiguration


    }

    /**
     *  64 bits  加密 秘钥
     *  @return
     */

    private fun getKey(): ByteArray? {
        return byteArrayOf(0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 2, 3, 4, 3, 2, 1)
    }


}
