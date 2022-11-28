package com.study.javabasic.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;

@Getter
@AllArgsConstructor
public class Subtitle {
    private String lang_cd;
    private String subtitle_path;

    @RequiredArgsConstructor
    public static class SubtitleComparator implements Comparator<Subtitle> {
        private final String order;

        @Override
        public int compare(Subtitle o1, Subtitle o2) {
            int idx1 = order.indexOf(o1.getLang_cd());
            int idx2 = order.indexOf(o2.getLang_cd());

            return idx1 > idx2 ? 1 : (idx1 == idx2 && o1.getLang_cd().length() < o2.getLang_cd().length() ? 1 : -1);
        }
    }
}
