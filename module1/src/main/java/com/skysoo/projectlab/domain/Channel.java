package com.skysoo.projectlab.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "channel")
public class Channel {
    @NotNull
    @Id
    @Column(name = "ch_id")
    private int chId;
    @Size(max = 1)
    @Column(name = "use_yn")
    private String useYN;
    @Column(name = "ins_dt")
    @CreationTimestamp
    private Timestamp insDt;
    @Column(name = "ins_id")
    @Size(max = 20)
    private String insId;
    @Column(name = "upd_dt")
    @CreationTimestamp
    private Timestamp updDt;
    @Column(name = "upd_id")
    @Size(max = 20)
    private String updId;
}
