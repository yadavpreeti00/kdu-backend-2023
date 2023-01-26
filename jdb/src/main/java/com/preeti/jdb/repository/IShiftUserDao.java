package com.preeti.jdb.repository;

import com.preeti.jdb.entity.ShiftUser;

import java.util.UUID;

public interface IShiftUserDao {
    ShiftUser createShiftUser(ShiftUser shiftUser);
    public ShiftUser selectShiftUser(UUID id, UUID tenantId);
}
