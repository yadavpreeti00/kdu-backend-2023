package com.preeti.jdb.repository;

import com.preeti.jdb.model.ShiftType;

import java.util.UUID;

public interface IShiftTypeDao {
    ShiftType getShiftType(UUID id, UUID tenantId);

    ShiftType createShiftType(ShiftType shiftType);
}
