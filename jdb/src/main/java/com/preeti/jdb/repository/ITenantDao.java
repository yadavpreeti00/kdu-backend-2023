package com.preeti.jdb.repository;

import com.preeti.jdb.entity.Tenant;
import org.springframework.transaction.TransactionStatus;

public interface ITenantDao {
    public void createTenant(Tenant tenant);
}
