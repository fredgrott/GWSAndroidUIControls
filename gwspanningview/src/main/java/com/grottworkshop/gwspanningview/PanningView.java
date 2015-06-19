/*
 * Copyright 2013 Flavien Laurent
 * Modifications Copyright 2015 Fred Grott(GrottWorkShop)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.grottworkshop.gwspanningview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * PanningView
 * usage:
 *
 * in your onCreate method of the main activity
 * <code>
 *     final PanningView panningView = (PanningView) findViewById(R.id.panningView);
 *
 *     findViewById(R.id.buttonStart).setOnClickListener(new View.OnClickListener() {
 *     @Override
 *     public void onClick(View v) {
 *         panningView.startPanning();
 *     }
 *      });
 *    findViewById(R.id.buttonStop).setOnClickListener(new View.OnClickListener() {
 *            @Override
 *            public void onClick(View v) {
 *                   panningView.stopPanning();
 *            }
 *        });
 *     findViewById(R.id.buttonChange).setOnClickListener(new View.OnClickListener() {
 *              @Override
 *              public void onClick(View v) {
 *                      mDrawableIndex++;
 *                      if(mDrawableIndex >= drawables.length) {
 *                              mDrawableIndex = 0;
 *                      }
 *                     panningView.setImageResource(drawables[mDrawableIndex]);
 *                 }
 *             });
 *
 * </code>
 * Created by fgrott on 6/16/2015.
 */
public class PanningView extends ImageView {

    private final PanningViewAttacher mAttacher;

    private int mPanningDurationInMs;

    public PanningView(Context context) {
        this(context, null);
    }

    public PanningView(Context context, AttributeSet attr) {
        this(context, attr, 0);
    }

    public PanningView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);
        readStyleParameters(context, attr);
        super.setScaleType(ScaleType.MATRIX);
        mAttacher = new PanningViewAttacher(this, mPanningDurationInMs);
    }

    /**
     * @param context the context
     * @param attributeSet the attributeset
     */
    private void readStyleParameters(Context context, AttributeSet attributeSet) {
        TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.PanningView);
        try {
            mPanningDurationInMs = a.getInt(R.styleable.PanningView_panningDurationInMs, PanningViewAttacher.DEFAULT_PANNING_DURATION_IN_MS);
        } finally {
            a.recycle();
        }
    }


    @Override
    // setImageBitmap calls through to this method
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        stopUpdateStartIfNecessary();
    }

    @Override
    public void setImageResource(int resId) {
        super.setImageResource(resId);
        stopUpdateStartIfNecessary();
    }

    @Override
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        stopUpdateStartIfNecessary();
    }

    private void stopUpdateStartIfNecessary() {
        if (null != mAttacher) {
            boolean wasPanning = mAttacher.isPanning();
            mAttacher.stopPanning();
            mAttacher.update();
            if(wasPanning) {
                mAttacher.startPanning();
            }
        }
    }


    @Override
    public void setScaleType(ScaleType scaleType) {
        throw new UnsupportedOperationException("only matrix scaleType is supported");
    }


    @Override
    protected void onDetachedFromWindow() {
        mAttacher.cleanup();
        super.onDetachedFromWindow();
    }

    public void startPanning() {
        mAttacher.startPanning();
    }

    public void stopPanning() {
        mAttacher.stopPanning();
    }
}