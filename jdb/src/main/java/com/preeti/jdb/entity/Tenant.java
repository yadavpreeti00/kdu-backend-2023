package com.preeti.jdb.entity;

import com.preeti.jdb.model.Shift;
import com.preeti.jdb.model.ShiftType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Tenant {

    private Shift shift;
    private User user;
    private ShiftType shiftType;
    private ShiftUser shiftUser;
}
