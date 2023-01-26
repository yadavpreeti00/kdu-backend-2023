package com.preeti.jdb.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Builder
@Getter
@Setter
public class ShiftType {
    private UUID id;
    private String uqName;
    private String description;
    private boolean active;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private String timeZone;
    private UUID tenantId;

}
