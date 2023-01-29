package com.preeti.springjpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ShiftType {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    private String uqName;
    private String description;

    @Getter
    private boolean active;

    private String timeZone;

    @ManyToOne
    @JoinColumn(name = "tenant_id", referencedColumnName = "id")
    private Tenant tenant;


    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

}
