package com.padc.yaepyaypar.Utils;

import com.padc.yaepyaypar.Utils.YaePyayParConstants;
import com.padc.yaepyaypar.YaePyayParApp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mkt on 9/16/2016.
 */
public class CommonUtils {

    public static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(YaePyayParConstants.EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
