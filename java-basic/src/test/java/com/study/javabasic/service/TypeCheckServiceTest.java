package com.study.javabasic.service;

import com.google.common.collect.Lists;
import com.study.javabasic.domain.EpisodeDTO;
import com.study.javabasic.domain.ImageDTO;
import com.study.javabasic.domain.VodFileDTO;
import com.study.javabasic.domain.VodFileEnum;
import com.study.javabasic.util.CommonUtils;
import org.junit.jupiter.api.Test;
import org.thymeleaf.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class TypeCheckServiceTest {

    @Test
    public void printLengthByType() {
        boolean isPrimitiveBoolean = true;
        byte primitiveByte = 1;
        short primitiveShort = 1;
        int primitiveInt = 1;
        long primitiveLong = 1;
        float primitiveFloat = 1;
        double primitiveDouble = 1;
        char primitiveChar = '1';
        String referenceString = "12";
        Boolean isReferenceBoolean = true;

        System.out.println(StringUtils.length(isPrimitiveBoolean));
        System.out.println(StringUtils.length(primitiveByte));
        System.out.println(StringUtils.length(primitiveShort));
        System.out.println(StringUtils.length(primitiveInt));
        System.out.println(StringUtils.length(primitiveLong));
        System.out.println(StringUtils.length(primitiveFloat));
        System.out.println(StringUtils.length(primitiveDouble));
        System.out.println(StringUtils.length(primitiveChar));
        System.out.println("=============");
        System.out.println(StringUtils.length(referenceString));
        System.out.println(isReferenceBoolean);


        Map addresses = new HashMap();
        Set set = addresses.keySet();
    }

    @Test
    public void 불필요한_객체_생성(){
        Map<Integer, String> temps = new HashMap<>();
        temps.put(1, "1");
        temps.put(2, "2");
        temps.put(3, "3");

        Set<Integer> tempsKeySet1 = temps.keySet();
        Set<Integer> tempsKeySet2 = temps.keySet();
        assertThat(tempsKeySet1).contains(1,2,3);

        tempsKeySet2.remove(3);
        assertThat(tempsKeySet1).doesNotContain(3);

    }

    @Test
    public void 스트림_null처리() {

        EpisodeDTO episodeDTO = new EpisodeDTO();
        HashMap<String, Object> episode_info = new HashMap<>();

        episode_info.put("stream70_yn", "Y");
        episode_info.put("stream70_url", "http://url.test.com");
        episode_info.put("stream60_yn", "N");
        episode_info.put("stream60_url", "http://url.test.com");
        episode_info.put("stream50_yn", null);
        episode_info.put("stream50_url", "http://url.test.com");
        episode_info.put("stream40_yn", "N");
        episode_info.put("stream40_url", null);

        ImageDTO streamDTO70 = new ImageDTO(); streamDTO70.setCode("stream70");  if (!CommonUtils.NVL(episode_info.get("stream70_yn")).equals("")) streamDTO70.setUrl(CommonUtils.NVL(episode_info.get("stream70_url")));
        ImageDTO streamDTO60 = new ImageDTO(); streamDTO60.setCode("stream60");  if (!CommonUtils.NVL(episode_info.get("stream60_yn")).equals("")) streamDTO60.setUrl(CommonUtils.NVL(episode_info.get("stream60_url")));
        ImageDTO streamDTO50 = new ImageDTO(); streamDTO50.setCode("stream50");  if (!CommonUtils.NVL(episode_info.get("stream50_yn")).equals("")) streamDTO50.setUrl(CommonUtils.NVL(episode_info.get("stream50_url")));
        ImageDTO streamDTO40 = new ImageDTO(); streamDTO40.setCode("stream40");  if (!CommonUtils.NVL(episode_info.get("stream40_yn")).equals("")) streamDTO40.setUrl(CommonUtils.NVL(episode_info.get("stream40_url")));
        ImageDTO streamDTO30 = new ImageDTO(); streamDTO30.setCode("stream30");  if (!CommonUtils.NVL(episode_info.get("stream30_yn")).equals("")) streamDTO30.setUrl(CommonUtils.NVL(episode_info.get("stream30_url")));
        ImageDTO streamDTO20 = new ImageDTO(); streamDTO20.setCode("stream20");  if (!CommonUtils.NVL(episode_info.get("stream20_yn")).equals("")) streamDTO20.setUrl(CommonUtils.NVL(episode_info.get("stream20_url")));
        ImageDTO streamDTO25 = new ImageDTO(); streamDTO25.setCode("stream25");  if (!CommonUtils.NVL(episode_info.get("stream25_yn")).equals("")) streamDTO25.setUrl(CommonUtils.NVL(episode_info.get("stream25_url")));
        List<ImageDTO> stream_meta_temp = Lists.newArrayList(streamDTO20, streamDTO25, streamDTO30, streamDTO40, streamDTO50, streamDTO60, streamDTO70);
        List<ImageDTO> stream_meta = stream_meta_temp.stream().filter(stream -> stream.getUrl()!=null).collect(Collectors.toList());
        episodeDTO.setStream_meta(stream_meta);
    }


    @Test
    public void nullCheck() {
        ImageDTO imageDTO = ImageDTO.builder()
                .url("url test")
                .build();

        String url = imageDTO.getUrl();
        String url2 = imageDTO.getUrl2();

        if(url != null) System.out.println(url);
        if(url2 != null) System.out.println(url2);
    }

    @Test
    public void nullCheck2() {
        HashMap<String, Object> program_info = new HashMap<>();
        Map<String, Object> testMap = new HashMap<>();

        testMap.put("test", program_info.get("code"));
        System.out.println(testMap.get("test"));

        ImageDTO imageDTO = ImageDTO.builder()
                .code(String.valueOf(program_info.get("code")))
                .url(CommonUtils.NVL(program_info.get("url"), "N"))
                .build();

        System.out.println(imageDTO.toString());

    }

    @Test
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
}


