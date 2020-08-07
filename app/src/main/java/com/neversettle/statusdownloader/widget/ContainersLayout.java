package com.neversettle.statusdownloader.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

import com.neversettle.statusdownloader.R;
import com.neversettle.statusdownloader.ui.utils.ViewUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.animation.ObjectAnimator.ofFloat;


public class ContainersLayout extends FrameLayout {

    public static final int ANIM_DURATION = 250;

    private static final String STATE_SUPER = "state_super";
    private static final String STATE_CONTAINERS_STATE = "state_containers_state";

    @BindView(R.id.activity_main__frame_master)
    ViewGroup frameMaster;
    @BindView(R.id.activity_main__frame_details)
    ViewGroup frameDetails;


    public ContainersLayout(Context context) {
        super(context);
        init();
    }

    public ContainersLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ContainersLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ContainersLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_main_containers, this, true);
        ButterKnife.bind(this);
    }

    private void animateInFrameDetails() {
        frameDetails.setVisibility(View.VISIBLE);
        ViewUtils.onLaidOut(frameDetails, new Runnable() {
            @Override
            public void run() {
                ObjectAnimator alpha = ObjectAnimator.ofFloat(frameDetails, View.ALPHA, 0.4f, 1f);
                ObjectAnimator translate = ofFloat(frameDetails, View.TRANSLATION_Y, frameDetails.getHeight() * 0.3f, 0f);

                AnimatorSet set = new AnimatorSet();
                set.playTogether(alpha, translate);
                set.setDuration(ANIM_DURATION);
                set.setInterpolator(new LinearOutSlowInInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        frameMaster.setVisibility(View.GONE);
                    }
                });
                set.start();
            }
        });
    }

    private void animateOutFrameDetails() {
        ViewUtils.onLaidOut(frameDetails, new Runnable() {
            @Override
            public void run() {
                if (!frameDetails.isShown()) {
                    return;
                }
                ObjectAnimator alpha = ObjectAnimator.ofFloat(frameDetails, View.ALPHA, 1f, 0f);
                ObjectAnimator translate = ofFloat(frameDetails, View.TRANSLATION_Y, 0f, frameDetails.getHeight() * 0.3f);

                AnimatorSet set = new AnimatorSet();
                set.playTogether(alpha, translate);
                set.setDuration(ANIM_DURATION);
                set.setInterpolator(new FastOutLinearInInterpolator());
                set.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        frameDetails.setAlpha(1f);
                        frameDetails.setTranslationY(0);
                        frameDetails.setVisibility(View.GONE);
                    }
                });
                set.start();
            }
        });
    }

}
