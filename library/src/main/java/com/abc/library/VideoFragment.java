package com.abc.library;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class VideoFragment extends Fragment {

    private VideoView videoView;
    private MediaController mediaController;
    private String src;

    public VideoFragment(String src) {
        this.src = src;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        videoView = view.findViewById(R.id.videoView);
        mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse(src));
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (mediaController != null) {
            mediaController.show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (mediaController != null) {
            mediaController.hide();
        }
    }

}
