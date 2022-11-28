package com.skysoo.projectlab.service;

import com.skysoo.projectlab.domain.Channel;
import com.skysoo.projectlab.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChannelService {
    private final ChannelRepository channelRepository;

    public Channel findById(int chId) {
        Optional<Channel> byId = channelRepository.findById(chId);
        return byId.orElse(null);
    }

    public void save(Channel channel) {
        channelRepository.save(channel);
    }
}
