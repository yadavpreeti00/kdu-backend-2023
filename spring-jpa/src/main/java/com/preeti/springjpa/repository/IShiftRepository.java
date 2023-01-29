package com.preeti.springjpa.repository;

import com.preeti.springjpa.entity.Shift;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface IShiftRepository extends JpaRepository<Shift, UUID> {

    @Query("SELECT s FROM Shift s WHERE s.dateStart = :startDate AND s.dateEnd = :endDate ORDER BY s.name ASC")
    List<Shift> findTop3ByStartDateAndEndDateOrderByNameAsc(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
