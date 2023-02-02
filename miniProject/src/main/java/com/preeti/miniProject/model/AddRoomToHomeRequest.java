package com.preeti.miniProject.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class AddRoomToHomeRequest {
    private String name;
    private UUID homeId;

}
