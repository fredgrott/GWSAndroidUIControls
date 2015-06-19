/*
 * Copyright 2015 chenupt
 * Modifications Copyright 2015 Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grottworkshop.gwsspringindicator.viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;


/**
 * FixedSpeedScroller
 * Created by fgrott on 6/16/2015.
 */
public class FixedSpeedScroller extends Scroller {

    private int mDuration = 1000;
    boolean useFixedSpeed = false;

    /**
     *
     * @param context the context
     */
    public FixedSpeedScroller(Context context) {
        super(context);
    }

    /**
     *
     * @param context the context
     * @param interpolator the interpolator
     */
    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    /**
     *
     * @param context the context
     * @param interpolator the interpolator
     * @param flywheel the flywheel boolean
     */
    public FixedSpeedScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }

    /**
     *
     * @param paramInt the paramInt int
     */
    public void setScrollAtFixedSpeed(int paramInt) {
        this.useFixedSpeed = true;
        this.mDuration = paramInt;
    }

    /**
     *
     * @param startX the startX int
     * @param startY the startY int
     * @param dx the dx int
     * @param dy the dy int
     * @param duration the duration int
     */
    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);

    }

    /**
     *
     * @param startX the startX int
     * @param startY the startY int
     * @param dx the dx int
     * @param dy the dy int
     */
    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    /**
     *
     * @param timeMilli the timeMilli int
     */
    public void setDuration(int timeMilli){
        this.mDuration = timeMilli;
    }
}