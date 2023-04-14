package com.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountmanager.entities.ExpenseCategory;

@Repository
public interface ExpenseCategoryRepo extends JpaRepository<ExpenseCategory, Integer>{

}
