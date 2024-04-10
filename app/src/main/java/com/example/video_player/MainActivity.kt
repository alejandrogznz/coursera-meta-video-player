package com.example.video_player

import android.net.Uri
import android.net.Uri.parse
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.video_player.databinding.ActivityMainBinding
import android.widget.VideoView
import android.widget.MediaController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val videoView = findViewById<VideoView>(binding.testView.id)

        //Creating MediaController
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val uri: Uri = parse(
            "android.resource://" + packageName + "/raw/index"
        )

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()

    }
}