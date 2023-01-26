package com.preeti.jdb.repository;

import com.preeti.jdb.model.Shift;

import java.util.UUID;

public interface IShiftDao {
    Shift createShift(Shift shift);

    Shift selectShift(UUID id,UUID tenantId);
}
