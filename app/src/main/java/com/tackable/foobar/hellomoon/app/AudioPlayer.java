package com.tackable.foobar.hellomoon.app;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by stevenwoo on 4/29/14.
 */
public class AudioPlayer extends Object {
    private MediaPlayer mPlayer;
    private boolean mPaused = false;
    public void stop(){
        if( mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener( new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                stop();
            }

        });
        mPlayer.start();
    }
    public void pause(){
        if( mPlayer != null ){
            if(!mPaused) {
                mPlayer.pause();
                mPaused = true;
            }
            else{
                mPlayer.start();
                mPaused = false;
            }
        }
    }
}
