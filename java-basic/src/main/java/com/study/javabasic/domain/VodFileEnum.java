package com.study.javabasic.domain;


import lombok.Getter;

@Getter
public enum VodFileEnum {
    fpdv("stream50","1080p"),
    hpdv("stream40","720p"),
    spdv("stream30","540p"),
    smdv("stream20","360p"),
    vpdv("stream25","480p"),
    fppc("stream50","1080p"),
    hppc("stream40","720p"),
    sppc("stream30","540p"),
    smpc("stream20","360p"),
    vppc("stream25","480p"),
    updv("stream70","4k"),
    fpwc("stream50","1080p"),
    hpwc("stream40","720p"),
    spwc("stream30","540p"),
    smwc("stream20","360p"),
    vpwc("stream25","480p"),
    fpfc("stream50","1080p"),
    hpfc("stream40","720p"),
    spfc("stream30","540p"),
    smfc("stream20","360p"),
    vpfc("stream25","480p"),
    fpnv("stream50","1080p"),
    hpnv("stream40","720p"),
    spnv("stream30","540p"),
    smnv("stream20","360p"),
    vpnv("stream25","480p"),
    fpnr("stream50","1080p"),
    hpnr("stream40","720p"),
    spnr("stream30","540p");

    private String stream;
    private String description;

    VodFileEnum(String stream, String description) {
        this.stream = stream;
        this.description = description;
    }
}

