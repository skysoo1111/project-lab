package com.skysoo.projectlab.cotroller;

import com.skysoo.projectlab.domain.Channel;
import com.skysoo.projectlab.service.ChannelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ChannelController {
    private final ChannelService channelService;

    @PostMapping("ch")
    void save(@RequestBody Channel channel) {
        channelService.save(channel);
    }

    @GetMapping("ch/{chId}")
    Channel findById(@PathVariable int chId){
        return channelService.findById(chId);
    }
}
