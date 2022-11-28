package com.skysoo.projectlab.repository;

import com.skysoo.projectlab.domain.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Integer> {
    @Query(value = "SELECT c FROM Channel c WHERE c.ch_id = :chId", nativeQuery = true)
    Channel findByid(@Param("chId") int chId);
}
