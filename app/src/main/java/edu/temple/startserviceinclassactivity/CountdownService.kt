package edu.temple.startserviceinclassactivity

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CountdownService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.run{
            val timer = getIntExtra(TIMER,0)
            CoroutineScope(Dispatchers.IO).launch {
                repeat(timer){
                    Log.d("Countdown", (timer - it).toString())
                    delay(1000)
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}