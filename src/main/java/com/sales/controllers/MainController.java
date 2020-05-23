package com.sales.controllers;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Book;
import com.sales.models.Customer;
import com.sales.models.Loan;
import com.sales.services.BookService;
import com.sales.services.CustomerService;
import com.sales.services.LoanService;

@Controller
public class MainController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CustomerService custService;
	
	@Autowired
	private LoanService loanService;
	
	private List<Book> books;
	
	private List<Loan> loans;
	
	private List<Customer> customers;
	
	
	
	//GET Index page, map to base url
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getIndexPage() {
		
		return "Index";
	}
	
	
	//GET Books list page, map to showBooks url, add list of book objects to model
	
	@RequestMapping(value="/showBooks", method=RequestMethod.GET)
	public String getShowBooksPage(Model m) throws Exception   {
		
		books = bookService.getBooks();
		
		m.addAttribute("books", books);
		
		return "showBooks";
	}
	
	
	//GET addBook page, map to addBook url, add book object to page
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public String getAddBookPage(Model m) {
		
		m.addAttribute("newBook", new Book());
		
		return "addBook";
	}
	
	
	//POST book object to database, use book service method to add to database
	
	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String addedNewBook(@Valid @ModelAttribute("newBook")Book b, BindingResult result) {
		
		//return to page if errors present
		if(result.hasErrors()) {
			return "addBook";
		}
		
		bookService.addBook(b);
		
		//redirect to show books page once book added
		return "redirect:showBooks";
	}
	
	
	//GET showCustomers page, get list of customers from customer service and add to page
	
	@RequestMapping(value="/showCustomers", method=RequestMethod.GET)
	public String getCustomersPage(Model m)  {
		
		customers = custService.getCustomersDetails();
		
		m.addAttribute("customers", customers);
		
		return "showCustomers";
	}
	
	
	//GET addCustomer page, add new customer object to page model
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.GET)
	public String getNewCustomerPage(Model m) {
		
		m.addAttribute("newCustomer", new Customer());
		
		return "addCustomer";
	}
	
	
	//POST new customer to database, use customer service method to add to database
	
	@RequestMapping(value="/addCustomer", method=RequestMethod.POST)
	public String addNewCustomer(@Valid @ModelAttribute("newCustomer")Customer c, BindingResult result)  {
		
		//return to page if errors present
		if(result.hasErrors()) {
			return "addCustomer";
		}
		
		custService.addNewCustomer(c);
		
		//redirect to show customers page after customer added
		return "redirect:showCustomers";
	}
	
	
	//GET showLoans page, add list to page model to display from loan service
	
	@RequestMapping(value="/showLoans", method=RequestMethod.GET)
	public String showLoanDetails(Model m) throws Exception   {
		
		loans = loanService.getLoansDetails();
		
		m.addAttribute("loans", loans);
		
		return "showLoans";
	}
	
	//GET newLoan page, add loan object to page model
	
	@RequestMapping(value="/newLoan", method=RequestMethod.GET)
	public String addLoanPage(Model m) {
		
		m.addAttribute("newLoan", new Loan());
		
		return "newLoan";
	}
	
	//POST new loan to database, forward error pages based on error encountered
	
	@RequestMapping(value="/newLoan", method=RequestMethod.POST)
	public String newLoanAdded(@ModelAttribute("newLoan")Loan loan, BindingResult result)
	{
		//var to check if you can get a book
		Loan bookLoan;
		
		//forward newLoanError page if null values
		
		if(loan.getBook().getBid() == null || loan.getCust().getcId() == null)
		{
			return "forward:/newLoanError/" + null + "/" + null;
		}
		
		//forward newLoanError page if book service method or customer service methods return null
		
		if(bookService.findBookById(loan.getBook().getBid()) == null || custService.findCustomerById(loan.getCust().getcId()) == null)
		{	
			return "forward:/newLoanError/" + loan.getCust().getcId() + "/" + loan.getBook().getBid();
		}
		
		//forward bookLoanError page if loan service method fails, forwards vars in url
		
		if(loanService.isBookAvailable(loan.getBook().getBid()) != null)
		{
			bookLoan = loanService.isBookAvailable(loan.getBook().getBid());
			
			return "forward:/bookLoanError/" + bookLoan.getCust().getcId() + "/" + loan.getBook().getBid() + "/" + 
													bookService.findBookById(loan.getBook().getBid()).getTitle() + "/" + bookLoan.getCust().getcName();
		}
		
		
		//get calendar instance
		
		Calendar c = Calendar.getInstance();
		
		//set calendar due date and format
		
		c.add(Calendar.DAY_OF_MONTH, custService.findCustomerById(loan.getCust().getcId()).getLoanPeriod());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = dateFormat.format(c.getTime());
		
		loan.setDueDate(date);
		
		loanService.addNewLoan(loan);
		
		//redirect after new loan added to database
		return "redirect:showLoans";
	}
	
	//Error page returned if can't create loan, path variables added to model
	
	@RequestMapping(value="/newLoanError/{cid}/{bid}")
	public String getLoanError(@PathVariable("cid")String cid, @PathVariable("bid")String bid, Model m)
	{
		
		m.addAttribute("cid", cid);
		
		m.addAttribute("bid", bid);
		
		return "newLoanError";
	}
	
	
	//Error page returned if book is already out on loan, path variables added to page model
	
	@RequestMapping(value="/bookLoanError/{cid}/{bid}/{title}/{name}")
	public String getBookLoanError(@PathVariable("cid")String cid, @PathVariable("bid")String bid, @PathVariable("title")String title, @PathVariable("name")String name, Model m)
	{
		
		m.addAttribute("cid", cid);
		
		m.addAttribute("bid", bid);
		
		m.addAttribute("title", title);
		
		m.addAttribute("cName", name);
		
		return "bookLoanError";
	}
	
	//GET deleteLoan page, add loan object to page model
	
	@RequestMapping(value="/deleteLoan", method=RequestMethod.GET)
	public String getDeleteLoan(Model m)
	{
		m.addAttribute("deleteLoan", new Loan());
		
		return "deleteLoan";
	}
	
	
	//POST delete a loan from the database, 
	
	@RequestMapping(value="/deleteLoan", method=RequestMethod.POST)
	public String deleteLoan(@ModelAttribute("deleteLoan")Loan loan)
	{
		//forward delteLoanError page if null value entered or loan service method returns null 
		if(loan.getLid() == null || loanService.findLoanById(loan.getLid()) == null)
		{
			return "forward:/deleteLoanError/" + loan.getLid();
		}
		
		loanService.deleteLoanById(loan.getLid());
		
		//redirect to show loans page after loan deleted from database
		return "redirect:showLoans";
	}
	
	
	//Error page returned if delete loan method fails, adds path variable to page model
	
	@RequestMapping(value="/deleteLoanError/{lid}")
	public String getDeleteLoanError(@PathVariable("lid")String lid, Model m)
	{	
		m.addAttribute("lid", lid);
		
		return "deleteLoanError";
	}
	
	// logout user, redirect to login page
	
	@RequestMapping(value="/logout")
	public String logoutUser(HttpServletRequest req, HttpServletResponse res)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth != null)
		{
			new SecurityContextLogoutHandler().logout(req, res, auth);
		}
		
		return "redirect:/login";
	}
	
}
