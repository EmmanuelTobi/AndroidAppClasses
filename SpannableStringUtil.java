package com.example.cosmic.androidappclasses;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;

/**
 * Created by ${cosmic} on 1/4/18.
 */

public class SpannableStringUtil extends Activity{

    private String[] all_strings;
    private String delimiter = "\n";
    private int i = 0;
    private Context context = this;
    int flag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;
    SpannableStringBuilder builder = new SpannableStringBuilder();
    private Typeface typeface;

    public SpannableStringBuilder styleBolder (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while (i < s_l) {
            SpannableString s = new SpannableString(all_strings[i] + "\n");
            s.setSpan(new StyleSpan(Typeface.BOLD), 0, s.length(), flag);
            builder.append(s);
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder styleUnderline (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while (i < s_l) {
            SpannableString s = new SpannableString(all_strings[i] + "\n");
            s.setSpan(new UnderlineSpan(), 0, s.length(), flag);
            builder.append(s);
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style2 (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while(i < s_l){
            if (i%2 != 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new RelativeSizeSpan(2), 0, s.length(), flag);
                builder.append(s);
            }
            else if (i%2 == 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan((Typeface.ITALIC), 0, s.length(), flag);
                builder.append(s);
            }
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style3 (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while(i < s_l){
            if (i == 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new UnderlineSpan(), 0, s.length(), flag);
                builder.append(s);
            }

            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style4 (String string, int color){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while(i < s_l){
            if (i%2 != 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), flag);
                s.setSpan(new BackgroundColorSpan(color), 0, s.length(), flag);
                builder.append(s);
            }
            else if (i%2 == 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan((Typeface.BOLD), 0, s.length(), flag);
                builder.append(s);
            }
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style5(String string, Typeface typeface, Typeface typeface1){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while(i < s_l){
            if (i%2 == 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new CustomTypefaceSpan("fabfeltscript-bold", typeface), 0, s.length(), flag);
                builder.append(s);
            }
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style6 (String string, int color){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while (i < s_l) {
            SpannableString s = new SpannableString(all_strings[i] + "\n");
            s.setSpan(new ForegroundColorSpan(Color.WHITE), 0, s.length(), flag);
            s.setSpan(new BackgroundColorSpan(color), 0, s.length(), flag);
            builder.append(s);
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style7 (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while (i < s_l) {
            if (i%2 != 0){
                SpannableString s = new SpannableString(all_strings[i] + " ");
                s.setSpan(new RelativeSizeSpan(2), 0, s.length(), flag);
                builder.append(s);
            }
            if (i%2 == 0){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new RelativeSizeSpan(0.5f), 0, s.length(), flag);
                builder.append(s);
            }
            ++i;
        }
        return builder;
    }

    public SpannableStringBuilder style8 (String string){
        all_strings = string.split(delimiter);
        int s_l = all_strings.length;
        i = 0;
        while (i < s_l){
            if (i == 2){
                SpannableString s = new SpannableString(all_strings[i] + "\n");
                s.setSpan(new RelativeSizeSpan(2), 0, s.length(), flag);
                s.setSpan(new UnderlineSpan(), 0, s.length(), flag);
                builder.append(s);
            }
            SpannableString s = new SpannableString(all_strings[i] + "\n");
            s.setSpan(new RelativeSizeSpan(0.8f), 0, s.length(), flag);
            builder.append(s);

            ++i;
        }
        return builder;
    }

    public void builderClear(){
        builder.clear();
    }

    /**
     * Created by ${cosmic} on 1/5/18.
     */

    @SuppressLint("ParcelCreator")
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        public CustomTypefaceSpan(String family, Typeface type) {
            super(family);
            newType = type;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            applyCustomTypeFace(ds, newType);
        }

        @Override
        public void updateMeasureState(TextPaint paint) {
            applyCustomTypeFace(paint, newType);
        }

        private static void applyCustomTypeFace(Paint paint, Typeface tf) {
            int oldStyle;
            Typeface old = paint.getTypeface();
            if (old == null) {
                oldStyle = 0;
            } else {
                oldStyle = old.getStyle();
            }
            int fake = oldStyle & ~tf.getStyle();
            if ((fake & Typeface.BOLD) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((fake & Typeface.ITALIC) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(tf);
        }
    }
}
