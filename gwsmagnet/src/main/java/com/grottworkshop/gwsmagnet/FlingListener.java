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

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * FlingListener
 * Created by fgrott on 6/17/2015.
 */
class FlingListener extends GestureDetector.SimpleOnGestureListener {

    private static final float FLING_THRESHOLD_VELOCITY = 50f;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return (Math.abs(e2.getX() - e1.getX()) < FLING_THRESHOLD_VELOCITY && e2.getY() - e1.getY() > FLING_THRESHOLD_VELOCITY);
    }

}