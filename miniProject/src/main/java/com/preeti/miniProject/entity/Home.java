package com.preeti.miniProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Home {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id")
    private UUID id;

    private String name;
    private String address;
    private Double latitude;
    private Double longitude;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms = new LinkedHashSet<>();

}
