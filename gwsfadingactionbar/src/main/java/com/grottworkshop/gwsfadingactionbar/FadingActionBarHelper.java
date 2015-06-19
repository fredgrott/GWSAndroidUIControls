/*
 * Copyright (C) 2013 Manuel Peinado
 * Modifications Copyright 2015 Fred Grott(GrottWorkShop)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grottworkshop.gwsfadingactionbar;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.drawable.Drawable;

/**
 * FadingActionBarHelper
 *
 * usage:
 *
 * usually in the onCreate of the activity
 * <code>
 *     FadingActionBarHelper helper = new FadingActionBarHelper()
 *       .actionBarBackground(R.drawable.ab_background)
 *       .headerLayout(R.layout.header)
 *       .contentLayout(R.layout.activity_listview)
 *       .headerOverlayLayout(R.layout.header_overlay);
 *      setContentView(helper.createView(this));
 *     helper.initActionBar(this);
 *
 * </code>
 *
 * @see FadingActionBarHelperBase for more settings
 *
 * Created by fgrott on 6/16/2015.
 */
public class FadingActionBarHelper extends FadingActionBarHelperBase {

    private ActionBar mActionBar;

    @Override
    public void initActionBar(Activity activity) {
        mActionBar = activity.getActionBar();
        super.initActionBar(activity);
    }


    @Override
    protected int getActionBarHeight() {
        return mActionBar.getHeight();
    }

    @Override
    protected boolean isActionBarNull() {
        return mActionBar == null;
    }


    @Override
    protected void setActionBarBackgroundDrawable(Drawable drawable) {
        mActionBar.setBackgroundDrawable(drawable);
    }
}
