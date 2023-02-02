package com.preeti.miniProject.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
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
//    @CreationTimestamp
//    private LocalDateTime createdAt;
//    @UpdateTimestamp
//    private LocalDateTime modifiedAt;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date deletedAt;

    @JsonIgnoreProperties
    @OneToMany(mappedBy = "home", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms = new LinkedHashSet<>();

}
