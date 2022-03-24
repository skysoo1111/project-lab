package com.skysoo.projectlab.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private int id;
    private String name;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Post> posts;
}
