package com.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountmanager.entities.Expense;
@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Integer>{

}
