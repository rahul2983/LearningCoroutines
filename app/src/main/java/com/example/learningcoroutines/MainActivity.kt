package com.example.learningcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tvDummy: TextView = findViewById(R.id.tvDummy)

//        GlobalScope.launch {
////            delay(1000L)
//            val networkCall = doNetworkCall()
//            val networkCall2 = doNetworkCall2()
//            Log.d(tag, "Coroutine says hello from thread ${Thread.currentThread().name}")
//            Log.d(tag, networkCall)
//            Log.d(tag, networkCall2)
//        }

//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d(tag, "Starting coroutine in thread ${Thread.currentThread().name}")
//            val answer = doNetworkCall()
//            withContext(Dispatchers.Main) {
//                Log.d(tag, "Setting text in thread ${Thread.currentThread().name}")
//                tvDummy.text = answer
//            }
//        }

//        Log.d(tag, "Before runBlocking")
//        runBlocking {
//            launch(Dispatchers.IO) {
//                delay(3000L)
//                Log.d(tag, "Finished IO Coroutine 1")
//            }
//
//            launch(Dispatchers.IO) {
//                delay(3000L)
//                Log.d(tag, "Finished IO Coroutine 2")
//            }
//
//            Log.d(tag, "Start of runBlocking")
//            delay(5000L)
//            Log.d(tag, "End of runBlocking")
//        }

//        Log.d(tag, "After runBlocking")

//        Log.d(tag, "Hello from thread ${Thread.currentThread().name}")

        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5) {
                Log.d(tag, "Coroutine is still working...")
                delay(1000L)
            }
        }

        runBlocking {
//            job.join()

            delay(2000L)
            job.cancel()

            Log.d(tag, "Main Thread is continuing...")
        }
    }

    suspend fun doNetworkCall(): String {
        delay(3000L)
        return "This is the answer"
    }

//    suspend fun doNetworkCall2(): String {
//        delay(3000L)
//        return "This is the second answer"
//    }
}