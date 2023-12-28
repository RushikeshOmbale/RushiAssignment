package com.RushikeshAssignment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.RushikeshAssignment.Entity.lead;

@Repository
public interface leadRepository extends JpaRepository<lead, Integer> {
	@Query("select u from lead u where u.id=:id")
	boolean existsByLeadId(@Param("id") int id);

	
	
	@Query("select u from lead u where u.mobileNumber=:mobileNumber")
	List<lead> findByMobileNumber(@Param("mobileNumber") String mobileNumber);

}
