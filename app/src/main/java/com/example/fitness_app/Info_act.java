package com.example.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_act extends AppCompatActivity {

    private VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_act);

        videoView = (VideoView)findViewById(R.id.vd);

        //Asignar nuestro video MP4 al videoView a traves de su ruta
        String ruta = "android.resource://"+ getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        //Controles
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);



    }



}