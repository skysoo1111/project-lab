package com.study.javabasic.util;

import java.util.Arrays;
import java.util.List;

public class CommonConstant {
    // screenCode
    public static final String SCREEN_CODE_PC = "CSSD0100";
    public static final String SCREEN_CODE_MOBILE = "CSSD0200";
    public static final String SCREEN_CODE_TABLET = "CSSD0300";
    public static final String SCREEN_CODE_GLOBAL_MOBILE = "CSSD2100";
    public static final String SCREEN_CODE_VIP_PC = "CSSD0700";
    public static final String SCREEN_CODE_VIP_MOBILE = "CSSD0800";
    public static final String SCREEN_CODE_SMART_LG = "CSSD1100";
    public static final String SCREEN_CODE_SMART_SAMSUNG = "CSSD1200";
    public static final String SCREEN_CODE_ANDROIDTV = "CSSD1300";
    public static final String SCREEN_CODE_APPLETV = "CSSD1400";
    @Deprecated
    public static final String SCREEN_CODE_SMART_TV = "CSSD0400";
    @Deprecated
    public static final String SCREEN_CODE_STICK = "CSSD0500";
    @Deprecated
    public static final String SCREEN_CODE_3RD = "CSSD0600";
    @Deprecated
    public static final String SCREEN_CODE_FULLHD = "CSSD1000";

    // 공통 코드 values
    public static final List<String> COMMON_SCREEN_CODES = Arrays.asList(
            SCREEN_CODE_PC, SCREEN_CODE_MOBILE, SCREEN_CODE_TABLET, SCREEN_CODE_SMART_TV,
            SCREEN_CODE_STICK, SCREEN_CODE_3RD, SCREEN_CODE_GLOBAL_MOBILE, SCREEN_CODE_VIP_PC,
            SCREEN_CODE_VIP_MOBILE, SCREEN_CODE_SMART_LG, SCREEN_CODE_SMART_SAMSUNG,
            SCREEN_CODE_ANDROIDTV, SCREEN_CODE_APPLETV);
}
