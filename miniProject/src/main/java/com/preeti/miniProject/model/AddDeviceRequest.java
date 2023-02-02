package com.preeti.miniProject.model;



import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
@Builder
public class AddDeviceRequest {

    private UUID kickstonId;
    private String deviceUsername;
    private String devicePassword;
}
