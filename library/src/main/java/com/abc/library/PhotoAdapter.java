package com.abc.library;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PhotoAdapter extends FragmentPagerAdapter {

    private static final String IMAGE = "(?i)\\.(jpg|jpeg)$";
    private static final String VIDEO = "(?i)\\.(mp4)$";

    private List<String> fs;

    public PhotoAdapter(FragmentManager fm, List<String> fs) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fs = fs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        String s = fs.get(position);
        if (s.matches(IMAGE)) {
            return new ImageFragment(s);
        } else if (s.matches(VIDEO)) {
            return new VideoFragment(s);
        }
        return null;
    }

    @Override
    public int getCount() {
        return fs == null ? 0 : fs.size();
    }

}
