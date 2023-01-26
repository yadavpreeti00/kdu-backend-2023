package com.preeti.jdb.entity;

import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShiftUser {

    private UUID id;
    private UUID shiftId;
    private UUID tenantId;
}
