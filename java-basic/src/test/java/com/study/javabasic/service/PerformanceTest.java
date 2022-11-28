package com.study.javabasic.service;

import com.study.javabasic.domain.Subtitle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceTest {
    private String subtitle ="NONE, KO, KO_CC, JA, JA_CC, EN, EN_CC, ZH, ZH_CC, TH, TH_CC, FR, FR_CC, ES, ES_CC, DE, DE_CC, RU, RU_CC, IT, IT_CC, AR, AR_CC, MS, MS_CC, FA, FA_CC, OT, OT_CC, EL, EL_CC, NL, NL_CC, SV, SV_CC, TR, TR_CC, PL, PL_CC, HU, HU_CC";

    @Test
    void comparator() {
        List<Subtitle> copy = Arrays.asList(new Subtitle("JA","http://url2.com")
                , new Subtitle("EN","http://url3.com")
                , new Subtitle("KO","http://url1.com")
        );

        Subtitle.SubtitleComparator subtitleComparator = new Subtitle.SubtitleComparator(subtitle);

        copy.stream()
                .sorted(subtitleComparator)
                .collect(Collectors.toList())
                .forEach(x -> System.out.println(x.getLang_cd()));

    }


}
