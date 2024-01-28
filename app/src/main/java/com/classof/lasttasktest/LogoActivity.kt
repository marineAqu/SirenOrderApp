package com.classof.lasttasktest

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class LogoActivity : AppCompatActivity() {

    var waveId : Int = 0
    val soundPool = SoundPool.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.logo)

        initSounds()

        soundPool.setOnLoadCompleteListener { _, _, _ ->
            soundPool.play(waveId, 1f, 1f, 1, 0, 1f)
        }

        // 일정 시간 지연 이후 실행하기 위한 코드
        Handler(Looper.getMainLooper()).postDelayed({

            val intent= Intent( this,MainActivity::class.java)
            startActivity(intent)

            soundPool.release()
            finish()

        }, 1500) // 시간 1.5초 이후 실행
    }
    fun initSounds(){
        waveId = soundPool.load(this,R.raw.wave,1)
    }

}