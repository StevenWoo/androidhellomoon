package com.tackable.foobar.hellomoon.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by stevenwoo on 4/29/14.
 */
public class HelloMoonFragment extends Fragment {
    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;
    private AudioPlayer mPlayer = new AudioPlayer();

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setRetainInstance(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent);
        mPlayButton = (Button)v.findViewById(R.id.hellomoon_playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });
        mStopButton = (Button)v.findViewById(R.id.hellomoon_stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.stop();
            }
        });
        mPauseButton = (Button)v.findViewById(R.id.hellomoon_pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlayer.pause();
            }
        });
        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }
}
