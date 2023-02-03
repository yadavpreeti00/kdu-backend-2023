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
public class DevicesAssigned {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "home_id", nullable = false)
    private Home home;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @OneToOne(optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private DeviceInventory deviceInventory;





}
