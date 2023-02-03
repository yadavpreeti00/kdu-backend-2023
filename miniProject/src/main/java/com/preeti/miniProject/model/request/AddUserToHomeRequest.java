package com.preeti.miniProject.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AddUserToHomeRequest {
    private UUID userId;
    private UUID homeId;
}
