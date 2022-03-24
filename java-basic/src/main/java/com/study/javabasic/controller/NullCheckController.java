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
import java.util.List;
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
}
