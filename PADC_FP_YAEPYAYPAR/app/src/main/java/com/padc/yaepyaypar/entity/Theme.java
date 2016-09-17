package com.padc.yaepyaypar.entity;

import android.support.annotation.ColorRes;
import android.support.annotation.StyleRes;

import com.padc.yaepyaypar.R;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public enum Theme {
    mapp(R.color.app_primary, R.color.app_primary_dark,
            R.color.theme_blue_background, R.color.theme_blue_text,
            R.color.app_accent, R.style.AppTheme),
    blue(R.color.theme_blue_primary, R.color.theme_blue_primary_dark,
            R.color.theme_blue_background, R.color.theme_blue_text,
            R.color.theme_blue_accent, R.style.AppTheme_Blue),
    green(R.color.theme_green_primary, R.color.theme_green_primary_dark,
            R.color.theme_green_background, R.color.theme_green_text,
            R.color.theme_green_accent, R.style.AppTheme_Green),
    purple(R.color.theme_purple_primary, R.color.theme_purple_primary_dark,
            R.color.theme_purple_background, R.color.theme_purple_text,
            R.color.theme_purple_accent, R.style.AppTheme_Purple),
    red(R.color.theme_red_primary, R.color.theme_red_primary_dark,
            R.color.theme_red_background, R.color.theme_red_text,
            R.color.theme_red_accent, R.style.AppTheme_Red),
    yellow(R.color.theme_yellow_primary, R.color.theme_yellow_primary_dark,
            R.color.theme_yellow_background, R.color.theme_yellow_text,
            R.color.theme_yellow_accent, R.style.AppTheme_Yellow);

    private final int mColorPrimaryId;
    private final int mWindowBackgroundColorId;
    private final int mColorPrimaryDarkId;
    private final int mTextColorPrimaryId;
    private final int mAccentColorId;
    private final int mStyleId;

    Theme(final int colorPrimaryId, final int colorPrimaryDarkId,
          final int windowBackgroundColorId, final int textColorPrimaryId,
          final int accentColorId, final int styleId) {
        mColorPrimaryId = colorPrimaryId;
        mWindowBackgroundColorId = windowBackgroundColorId;
        mColorPrimaryDarkId = colorPrimaryDarkId;
        mTextColorPrimaryId = textColorPrimaryId;
        mAccentColorId = accentColorId;
        mStyleId = styleId;
    }

    @ColorRes
    public int getTextPrimaryColor() {
        return mTextColorPrimaryId;
    }

    @ColorRes
    public int getWindowBackgroundColor() {
        return mWindowBackgroundColorId;
    }

    @ColorRes
    public int getPrimaryColor() {
        return mColorPrimaryId;
    }

    @ColorRes
    public int getAccentColor() {
        return mAccentColorId;
    }

    @ColorRes
    public int getPrimaryDarkColor() {
        return mColorPrimaryDarkId;
    }

    @StyleRes
    public int getStyleId() {
        return mStyleId;
    }
}
