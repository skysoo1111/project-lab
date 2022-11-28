package com.study.javabasic.service;

import com.study.javabasic.domain.ImageDTO;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    void test1() {
        ImageDTO imageDTO = Optional.ofNullable(getImage())
                .map(x -> setUrl(x, "url"))
                .orElse(null);

//        ImageDTO x = null;
//        ImageDTO image = getImage();
//        if (image != null) x = image;
//        if (x == null) {
//            System.out.println("not found");
//        } else {
//            setUrl(x, "url");
//        }
//
//        Optional.ofNullable(getImage())
//                .ifPresentOrElse(y -> setUrl(y,"url"),
//                        () -> System.out.println("not found"));
//

        System.out.println(imageDTO);
    }

    ImageDTO getImage() {
//        return new ImageDTO();
        return null;
    }

    ImageDTO setUrl(ImageDTO imageDTO, String url) {
        imageDTO.setUrl(url);
        return imageDTO;
    }
}
