/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Prem Nirmal
 * Modifications Copyright 2105 Fred Grott(GrottWorkShop)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.grottworkshop.gwsmagnet;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;


/**
 * ViewHolder for the remove Icon.
 * Created by fgrott on 6/17/2015.
 */
class RemoveView {

    View mLayout;
    View mButton;
    View mShadow;
    ImageView mButtonImage;
    private WindowManager mWindowManager;
    private SimpleAnimator mShowAnim;
    private SimpleAnimator mHideAnim;

    private SimpleAnimator mShadowFadeOut;
    private SimpleAnimator mShadowFadeIn;

    private final int buttonBottomPadding;

    boolean shouldBeResponsive = true;

    RemoveView(Context context) {
        mLayout = LayoutInflater.from(context).inflate(R.layout.magnet_x_button_holder, null);
        mButton = mLayout.findViewById(R.id.xButton);
        mButtonImage = (ImageView) mLayout.findViewById(R.id.xButtonImg);
        mButtonImage.setImageResource(R.drawable.trash);
        buttonBottomPadding = mButton.getPaddingBottom();
        mShadow = mLayout.findViewById(R.id.shadow);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        addToWindow(mLayout);
        mShowAnim = new SimpleAnimator(mButton, R.anim.magnet_slide_up);
        mHideAnim = new SimpleAnimator(mButton, R.anim.magnet_slide_down);
        mShadowFadeIn = new SimpleAnimator(mShadow, android.R.anim.fade_in);
        mShadowFadeOut = new SimpleAnimator(mShadow, android.R.anim.fade_out);
        hide();
    }

    void setIconResId(int id) {
        mButtonImage.setImageResource(id);
    }

    void setShadowBG(int shadowBG) {
        mShadow.setBackgroundResource(shadowBG);
    }

    void show() {
        if (mLayout != null && mLayout.getParent() == null) {
            addToWindow(mLayout);
        }
        mShadowFadeIn.startAnimation();
        mShowAnim.startAnimation();
    }

    void hide() {
        mShadowFadeOut.startAnimation();
        mHideAnim.startAnimation(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (mLayout != null && mLayout.getParent() != null) {
                    mWindowManager.removeView(mLayout);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    void onMove(final float x, final float y) {
        if (shouldBeResponsive) {
            final int xTransformed = (int) Math.abs(x * 100 / (mButton.getContext().getResources().getDisplayMetrics().widthPixels / 2));
            final int bottomPadding = buttonBottomPadding - (xTransformed / 5);
            if (x < 0) {
                mButton.setPadding(0, 0, xTransformed, bottomPadding);
            } else {
                mButton.setPadding(xTransformed, 0, 0, bottomPadding);
            }
        }
    }

    void destroy() {
        if (mLayout != null && mLayout.getParent() != null) {
            mWindowManager.removeView(mLayout);
        }
        mLayout = null;
        mWindowManager = null;
    }

    private void addToWindow(View layout) {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
                PixelFormat.TRANSLUCENT
        );
        mWindowManager.addView(layout, params);
    }
}
