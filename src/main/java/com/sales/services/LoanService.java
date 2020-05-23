package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Loan;
import com.sales.repositories.LoanRepository;

@Service
public class LoanService {
	
	@Autowired
	private LoanRepository loanRepo;
	
	private List<Loan> loanList;
	
	
	//return list of loans from database
	
	public List<Loan> getLoansDetails()  
	{
		loanList = (List<Loan>)loanRepo.findAll();
		
		return loanList;
	}
	
	//
	
	public Loan addNewLoan(Loan loan)  
	{
		return loanRepo.save(loan);
	}
	
	//checks database to see if book already on loan, uses native repository query
	
	public Loan isBookAvailable(Long id)  
	{
		Loan loan = null;
		
		//return null if loan repository method returns null
		if(loanRepo.bookAlreadyOnLoan(id) == null) {
			return loan;
		}
		
		//assign if not null
		loan = loanRepo.bookAlreadyOnLoan(id);
		
		return loan;
	}
	
	
	//finds loan by id, returns instance if found
	
	public Loan findLoanById(Long id)   
	{
		return loanRepo.findOne(id);
	}
	
	
	//delete loan from database by id passed
	
	public void deleteLoanById(Long id)  
	{
		loanRepo.delete(id);
	}

}
