/*
 * Copyright 2015 Fred Grott(GrottWorkShop)
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
package com.grottworkshop.gwstextkern;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ScaleXSpan;

/**
 * KerningUtil,  applyKerning is a helper method to adjust  text spacing, kerning, when you are
 * not able to use the KerningTextView in this library. For example, if you modified the TextView
 * for something else for example.
 *
 * @author Fred Grott
 * Created by fgrott on 6/18/2015.
 */
public class KerningUtil {

    /**
     *
     * @param src the Character sequence to apply kerning to
     * @param kerning the float kerning value
     * @param start what position in the CharSequence to start applying kerning
     * @param end what end position in the CharSequence to end applying kerning
     * @return a SpannableStringBuilder result
     */
    public static Spannable applyKerning(CharSequence src, float kerning, int start, int end)
    {
        if (src == null) return null;
        final int srcLength = src.length();
        if (srcLength < 2) return src instanceof Spannable
                ? (Spannable)src
                : new SpannableString(src);
        if (start < 0) start = 0;
        if (end > srcLength) end = srcLength;

        final String nonBreakingSpace = "\u00A0";
        final SpannableStringBuilder builder = src instanceof SpannableStringBuilder
                ? (SpannableStringBuilder)src
                : new SpannableStringBuilder(src);
        for (int i = src.length(); i >= 1; i--)
        {
            builder.insert(i, nonBreakingSpace);
            builder.setSpan(new ScaleXSpan(kerning), i, i + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return builder;
    }

}
