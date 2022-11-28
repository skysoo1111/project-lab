package com.skysoo.projectlab;

import com.skysoo.projectlab.configuration.DatabaseConfig;
import com.skysoo.projectlab.domain.Channel;
import com.skysoo.projectlab.repository.ChannelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DatabaseConfig.class})
public class AppToDBTest {

    @Autowired
    private ChannelRepository channelRepository;

    @Test
    void insertTimeStamp() {
        Channel channel = Channel.builder()
                .chId(1)
                .useYN("Y")
                .insId("soo")
                .updId("soo")
                .build();
        channelRepository.save(channel);
    }

    @Test
    void selectTimeStamp() {
        channelRepository.findByid(1);
    }
}
