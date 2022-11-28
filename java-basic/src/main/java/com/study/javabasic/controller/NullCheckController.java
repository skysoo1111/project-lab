package com.study.javabasic.controller;

import com.study.javabasic.domain.VodFileDTO;
import com.study.javabasic.domain.VodFileEnum;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Null Check Controller
 */
@RequestMapping("/v1")
@RestController
public class NullCheckController {

    /*
     * enum 변환시 존재하지 않는 enum 일 때, 동작 체크
     */
    @GetMapping("/enumCheck/{profile}")
    public ModelAndView enumTypeCheck(@PathVariable String profile) {
        ModelAndView mv = new ModelAndView();
        List<VodFileDTO> vodFileDTOList = new ArrayList<>();
        VodFileDTO vodFileDTO1 = VodFileDTO.builder()
                .profile_cd(profile)
                .build();
        vodFileDTOList.add(vodFileDTO1);

//        List<VodFileDTO> newVodFileDTOS = vodFileDTOList.stream().map(vodFileDTO -> {
//            try {
//                String stream = VodFileEnum.valueOf(vodFileDTO.getProfile_cd()).getStream();
//                vodFileDTO.setCont_cd(String.valueOf(RandomUtils.nextInt()));
//                vodFileDTO.setProfile_cd(stream);
//            } catch (Exception e) {
//                System.out.println(".syncVodFilePathByVingo >> " + e.getLocalizedMessage());
//            }
//            return vodFileDTO;
//        }).collect(Collectors.toList());

        List<VodFileDTO> newVodFileDTOS = vodFileDTOList.stream().map(vodFileDTO -> {
            String stream = VodFileEnum.valueOf(vodFileDTO.getProfile_cd()).getStream();
            vodFileDTO.setCont_cd(String.valueOf(RandomUtils.nextInt()));
            vodFileDTO.setProfile_cd(stream);
            return vodFileDTO;
        }).collect(Collectors.toList());

        mv.addObject("newVodFileDTOS", newVodFileDTOS);
        mv.setViewName("test");
        return mv;
    }

    @GetMapping("/lambdaCheck")
    public void lambdaCheck() {
        try{
            List<VodFileDTO> vodFileDTOS = new ArrayList<>();
            if(vodFileDTOS != null) {
                List<VodFileDTO> newVodFileDTOS = vodFileDTOS.stream().map(vodFileDTO -> {
                    String stream = VodFileEnum.valueOf(vodFileDTO.getProfile_cd()).getStream();
                    vodFileDTO.setCont_cd("tvingCd");
                    vodFileDTO.setProfile_cd(stream);
                    return vodFileDTO;
                }).collect(Collectors.toList());
                newVodFileDTOS.forEach(vodFileDTO -> System.out.println(vodFileDTO.getProfile_cd()));
            }

        }catch(Exception ex){
            System.out.println("mongo movie update Exception {}"+ ex.toString());
        }
    }

    @GetMapping("/paramGet/null")
    public void paramGetNullCheck() {
        Map<String,Object> pipEpiMap = new HashMap<>();
        List<Map<String, Object>> pipTvingSubtitleInfo = null;
//        List<Map<String, Object>> pipTvingSubtitleInfo = new ArrayList<>();
        pipEpiMap.put("pipTvingSubtitleInfo",pipTvingSubtitleInfo);


        try {
            Map<String,Object> pgmMap = new HashMap<String,Object>();
//        if (pipEpiMap.get("pipTvingSubtitleInfo") != null) {
//            System.out.println("!=null");
//            pgmMap.put("pip_subtitle_info", pipEpiMap.get("pipTvingSubtitleInfo")); //PIP 자막 정보
//        }

            pgmMap.put("pip_subtitle_info", pipEpiMap.get("pipTvingSubtitleInfo"));
            getList(pgmMap);

            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
        } catch (Exception e){
            System.out.println(this.getClass().getSimpleName() +">>> "+e.getLocalizedMessage());
        }


    }

    public void getList(Map<String, Object> params) {
        List<Map<String, String>> result = (List<Map<String, String>>) params.get("pip_subtitle_info");
        for (Map<String, String> map : result) {
            String test = map.get("test");
            System.out.println(test);
        }
//        try {
//            List<Map<String, String>> result = (List<Map<String, String>>) params.get("pip_subtitle_info");
//            for (Map<String, String> map : result) {
//                String test = map.get("test");
//                System.out.println(test);
//            }
//        } catch (Exception e){
//            System.out.println(this.getClass().getSimpleName() +">>> "+e.getLocalizedMessage());
//        }
    }
}
