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

import android.view.View;

/**
 * Interface that gives the user callbacks for when the MagnetIcon has been interacted with.
 * Created by fgrott on 6/17/2015.
 */
public interface IIconCallback {

    /**
     * Insert code for what to do when the icon has been flung away
     */
    public void onFlingAway();

    /**
     * Callback for when the icon has been dragged by the user
     * @param x x coordiante on the screen in pixels
     * @param y y coordinate on the screen in pixels
     */
    public void onMove(float x, float y);

    /**
     * Callback for when the icon has been clicked. Perform any action such as launch your app,
     * or show a menu, etc.
     * @param icon the view holding the icon. Get context from this view.
     * @param iconXPose the x coordinate of the icon in pixels
     * @param iconYPose the y coordiante of the icon in pixels
     */
    public void onIconClick(View icon, float iconXPose, float iconYPose);


    /**
     * Callback for when the icon has been destroyed. Usually you should stop your service in this.
     */
    public void onIconDestroyed();
}