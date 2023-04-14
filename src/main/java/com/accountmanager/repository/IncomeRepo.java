package com.accountmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountmanager.entities.Income;


@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {


}
