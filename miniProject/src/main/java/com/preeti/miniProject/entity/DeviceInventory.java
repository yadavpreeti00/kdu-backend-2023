package com.preeti.miniProject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DeviceInventory {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID kickstonId;

    @Column(nullable = false, unique = true)
    private String deviceUsername;

    @Column(nullable = false, unique = true)
    private String devicePassword;

    @Column(nullable = false)
    private Boolean purchased;
//    @CreationTimestamp
//    private LocalDateTime manufactureDateTime;

    private String manufactureFactoryPlace;

}
