package com.skysoo.projectlab.repository;

import com.skysoo.projectlab.dto.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow,Integer> {
}
