package com.sentila.mobileproject;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class MainActivity extends  TabActivity  {

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();


        TabSpec tabSpec1 = tabHost.newTabSpec("TAG1").setIndicator("정보 변경");
        tabSpec1.setContent(new Intent(this,MyInformaiton.class));
        tabHost.addTab(tabSpec1);

        TabSpec tabSpec2 = tabHost.newTabSpec("TAG2").setIndicator("최신 영화");
        tabSpec2.setContent(new Intent(this, NewMovielist.class));
        tabHost.addTab(tabSpec2);

        TabSpec tabSpec3 = tabHost.newTabSpec("TAG3").setIndicator("로그인");
        tabSpec3.setContent(new Intent(this, Login.class));
        tabHost.addTab(tabSpec3);

        TabSpec tabSpec4 = tabHost.newTabSpec("TAG4").setIndicator("지도");
        tabSpec4.setContent(new Intent(this, MovieMap.class));
        tabHost.addTab(tabSpec4);

        TabSpec tabSpec5 = tabHost.newTabSpec("TAG5").setIndicator("글쓰기");
        tabSpec5.setContent(new Intent(this, MainDataBase .class));
        tabHost.addTab(tabSpec5);



    }
}
