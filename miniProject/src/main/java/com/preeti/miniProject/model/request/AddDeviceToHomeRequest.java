package com.preeti.miniProject.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class AddDeviceToHomeRequest {

    private UUID kickstonId;
    private UUID homeId;
    private UUID roomId;
}
