package com.accountmanager.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.accountmanager.entities.Expense;
import com.accountmanager.entities.ExpenseCategory;
import com.accountmanager.entities.Income;
import com.accountmanager.entities.IncomeCategory;
import com.accountmanager.entities.User;
import com.accountmanager.repository.ExpenseCategoryRepo;
import com.accountmanager.repository.ExpenseRepo;
import com.accountmanager.repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseRepo rep;
	
	@Autowired
	private ExpenseCategoryRepo erep;
	
	@Autowired
	private UserRepo urep;
	
	
	
	@GetMapping(path = "/exp")
	public String add(Model model) {
		List<ExpenseCategory> categories = erep.findAll();
		model.addAttribute("categories", categories);
		return "expense";
	}
	
	@PostMapping("/addexpense")
	public String addExpense(HttpServletRequest request, Model model) {
		 HttpSession session = request.getSession(); 
		  Date dt = Date.valueOf(request.getParameter("date")) ;
		  
		  String nm = request.getParameter("name"); 
		  String dsc = request.getParameter("description"); 
		  double a = Double.parseDouble(request.getParameter("amount")); 
		  String md = request.getParameter("mode"); 
		  String txn = request.getParameter("transactionId"); 
		  int cid = Integer.parseInt( request.getParameter("category"));
		  ExpenseCategory ic = erep.findById(cid).get();
		  int usrid = (Integer)session.getAttribute("uid");
		  User usr = urep.findById(usrid).get();
		 Expense expense =new  Expense(dt, nm, dsc, a, md, txn, usr, ic); 
		  rep.save(expense);
		    
		  return "home";
		  				
	}
	
	@GetMapping(path = "/showallexp")
	public String showAll(Model model) {
		List<Expense> expenses= rep.findAll();
		model.addAttribute("expenses", expenses);
		return "showexpense";
	}
}
