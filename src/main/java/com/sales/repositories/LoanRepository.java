package com.sales.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sales.models.Loan;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {
	
	//write native query to be used in loan service to find id in database
	@Query(value="select * from loans l where l.bid = :id", nativeQuery=true)
	public Loan bookAlreadyOnLoan(@Param("id") Long id);

}
