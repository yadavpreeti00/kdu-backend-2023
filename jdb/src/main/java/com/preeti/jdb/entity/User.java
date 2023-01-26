package com.preeti.jdb.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Builder
@Getter
@Setter
public class User {

    private UUID id;
    private String username;
    private short loggedin;
    private String timeZone;
    private UUID tenantId;


}
