package com.preeti.miniProject.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
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


    private String manufactureFactoryPlace;

}
