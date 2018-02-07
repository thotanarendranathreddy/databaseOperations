package com.ustri.jpa.pagination;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.model.Employee;
@Repository
public interface page extends PagingAndSortingRepository<Employee,Integer> {

	
	
}
