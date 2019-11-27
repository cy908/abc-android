package com.abc.library;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PhotoActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        viewPager = findViewById(R.id.viewPager);
        FragmentManager fm = getSupportFragmentManager();
        String dir = getExternalFilesDir(null).getAbsolutePath();
        List<String> fs = fs(dir);
        PhotoAdapter photoAdapter = new PhotoAdapter(fm, fs);
        viewPager.setAdapter(photoAdapter);
    }

    private List<String> fs(String dir){
        File root = new File(dir);
        List<String> fs = new ArrayList<>();
        for (String f: root.list()) {
            fs.add(f);
        }
        return fs;
    }

}
