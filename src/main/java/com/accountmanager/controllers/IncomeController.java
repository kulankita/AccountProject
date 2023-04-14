package com.accountmanager.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accountmanager.entities.Income;
import com.accountmanager.entities.IncomeCategory;
import com.accountmanager.entities.User;
import com.accountmanager.repository.IncomeCategoryRepo;
import com.accountmanager.repository.IncomeRepo;
import com.accountmanager.repository.UserRepo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IncomeController {

	@Autowired
	private IncomeRepo rep;

	@Autowired
	private UserRepo urep;
	
	@Autowired
	private IncomeCategoryRepo irep;

	@GetMapping(path = "/inc")
	public String add(Model model) {
		List<IncomeCategory> categories = irep.findAll();
		model.addAttribute("categories", categories);
		return "income";
	}
	
	  @PostMapping("/addincome") 
	  public String addIncome(HttpServletRequest request, Model model) {
	  HttpSession session = request.getSession(); 
	  Date dt = Date.valueOf(request.getParameter("date")) ;  
	  String nm = request.getParameter("name"); 
	  String dsc = request.getParameter("description"); 
	  double a = Double.parseDouble(request.getParameter("amount")); 
	  String md = request.getParameter("mode"); 
	  String txn = request.getParameter("transactionId"); 
	  int cid = Integer.parseInt( request.getParameter("category"));
	  IncomeCategory ic = irep.findById(cid).get();
	  int usrid = (Integer)session.getAttribute("uid");
	  User usr = urep.findById(usrid).get();
	  Income income =new  Income(dt, nm, dsc, a, md, txn, usr, ic); 
	  rep.save(income);
	    
	  return "home";
	  
	  }
	  
	  @GetMapping(path = "/showallinc")
		public String showAll(Model model) {
			List<Income> incomes= rep.findAll();
			model.addAttribute("incomes", incomes);
			return "showincome";
		}
	 }
