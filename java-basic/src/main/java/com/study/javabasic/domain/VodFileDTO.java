package com.study.javabasic.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study.javabasic.util.CommonUtils;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VodFileDTO implements Serializable {
    private static final long serialVersionUID = 8548205887254307998L;

    @JsonProperty("MAST_CD")
    private String mast_cd;
    @JsonProperty("CONT_CD")
    private String cont_cd;
    @JsonProperty("PROFILE_CD")
    private String profile_cd;
    @JsonProperty("CONTENTS_TYPE")
    private String contents_type;
    @JsonProperty("PROFILE_URL")
    private String profile_url;
    @JsonProperty("DRM_YN")
    private String drm_yn;
    @JsonProperty("DRM_KEY")
    private String drm_key;
    @JsonProperty("FILE_SIZE")
    private String file_size;
    @JsonProperty("INS_DT")
    private String ins_dt;
    @JsonProperty("UPD_DT")
    private String upd_dt;
    @JsonProperty("STATUS")
    private String status;

    // mongo 에서 사용하는 필드
    private String code;
    private String url;
    private String insert_date;
    private String update_date;

    public Map<String,String> from(VodFileDTO vodFileDTO) {
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("mast_cd", vodFileDTO.getMast_cd());
        resultMap.put("cont_cd", vodFileDTO.getCont_cd());
        resultMap.put("profile_cd", vodFileDTO.getProfile_cd());
        resultMap.put("profile_url", vodFileDTO.getProfile_url());
        resultMap.put("contents_type", vodFileDTO.getContents_type());
        resultMap.put("drm_yn", vodFileDTO.getDrm_yn());
        resultMap.put("drm_key", vodFileDTO.getDrm_key());
        resultMap.put("file_size", vodFileDTO.getFile_size());
        resultMap.put("stream_info", StreamCodeEnum.valueOf(vodFileDTO.getProfile_cd()).getDescription());
        return resultMap;
    }

    public VodFileDTO toMongo(VodFileDTO vodFileDTO){
        return VodFileDTO.builder()
                .code(vodFileDTO.getProfile_cd())
                .url(vodFileDTO.getProfile_url())
                .drm_key(CommonUtils.NVL(vodFileDTO.getDrm_key()))
                .drm_yn(vodFileDTO.getDrm_yn())
                .file_size(vodFileDTO.getFile_size())
                .build();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}