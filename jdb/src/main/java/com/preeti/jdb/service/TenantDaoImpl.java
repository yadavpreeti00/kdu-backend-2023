package com.preeti.jdb.service;

import com.preeti.jdb.entity.Tenant;
import com.preeti.jdb.repository.ITenantDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.NoSuchElementException;

@Slf4j
@Repository
@RequiredArgsConstructor

public class TenantDaoImpl implements ITenantDao {


    private final ShiftDaoImpl shiftDao;
    private final UserDaoImpl userDao;
    private final ShiftTypeDaoImpl shiftTypeDao;
    private final ShiftUserDaoImpl shiftUserDao;

    @Transactional(rollbackFor = Exception.class,noRollbackFor = NoSuchElementException.class)
    public void createTenant(Tenant tenant)
    {
                    shiftDao.createShift(tenant.getShift());
                    userDao.insert(tenant.getUser());
                    shiftTypeDao.createShiftType(tenant.getShiftType());
                    shiftUserDao.createShiftUser(tenant.getShiftUser());
    }
}
