package com.example.sendmessage;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName("Your Full Name")
                .setSubTitle("Mobile Developer")
                .setBrief("I'm warmed of mobile technologies. Ideas maker, curious and nature lover.")
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("user")
                .addFacebookLink("user")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();


        //addContentView(view, layoutParams);
    }
}

