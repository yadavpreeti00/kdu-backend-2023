package com.preeti.miniProject.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class MoveDeviceWithinHomeRequest {

    private UUID kickstonId;
    private UUID homeId;
    private UUID roomId;

}
