package com.accountmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accountmanager.entities.IncomeCategory;
import com.accountmanager.entities.User;

@Repository
public interface IncomeCategoryRepo extends JpaRepository<IncomeCategory, Integer> {

	/*
	 * @Query("select u from com.accountmanager.entities.IncomeCategory u where u.name=?1 and u.description=?2"
	 * ) public IncomeCategory findCategoryName(String name, String desc);
	 */
	
}
