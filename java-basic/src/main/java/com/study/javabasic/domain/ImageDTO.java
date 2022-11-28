package com.study.javabasic.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImageDTO {

    private static final long serialVersionUID = -5829044162547930602L;

    private String url;
    private String url2; // NON DRM 전용 URL
    private String code;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl2() {
        return url2;
    }
    public void setUrl2(String url2) {
        this.url2 = url2;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


}