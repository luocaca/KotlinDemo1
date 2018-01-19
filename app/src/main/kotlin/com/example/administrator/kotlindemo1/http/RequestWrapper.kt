package com.example.administrator.kotlindemo1.http

import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 *  OkHttp是一个成熟且强大的网络库，
 *  在Android源码中已经使用OkHttp替代原先的HttpURLConnection。
 *  很多著名的框架例如Picasso、Retrofit也使用OkHttp作为底层框架。
 *  在这里我对OkHttp做一下简单的封装，
 *  其实封装得有点粗暴只是为了演示如何实现dsl。
 */

class RequestWrapper {


    var url: String? = null

    var method: String? = null

    var body: RequestBody? = null

    var timeout: Long? = null

    internal var _success: (String) -> Unit = {}

    internal var _fail: (Throwable) -> Unit = {}


    fun onSuccess(onSuccess: (String) -> Unit) {
        _success = onSuccess
    }

    fun onFaild(onError: (Throwable) -> Unit) {
        _fail = onError
    }


    fun http(init: RequestWrapper.() -> Unit) {
        val wrap = RequestWrapper()

        wrap.init()

        executeForResult(wrap)


    }


    /**
     *
     */
    private fun executeForResult(wrap: RequestWrapper) {

        Flowable.create<Response>({ e ->
            e.onNext(onExecute(wrap)!!)
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { resp ->
                            wrap._success(resp.body()!!.string())
                        },
                        { e ->
                            wrap._fail(e)
                        })
    }

    private fun onExecute(wrap: RequestWrapper): Response? {

        var req: Request? = null;
        when (wrap.method) {
            "get", "Get", "GET" -> req = Request.Builder().url(wrap.url).build()
            "post", "Post", "POST" -> req = Request.Builder().url(wrap.url).post(wrap.body).build()
            "put", "Put", "PUT" -> req = Request.Builder().url(wrap.url).put(wrap.body).build()
            "delete", "Delete", "DELETE" -> req = Request.Builder().url(wrap.url).delete(wrap.body).build()
        }

//        val http = OkHttpClient.Builder().connectTimeout(wrap.timeout!!, TimeUnit.SECONDS).build()
//        val resp = http.newCall(req).execute()
//        return resp

        val http = OkHttpClient.Builder().connectTimeout(wrap.timeout!!, TimeUnit.MILLISECONDS).build()
        val resp = http.newCall(req).execute()
        return resp
    }


}
