package edu.utkarsh.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utkarsh.springboot.dto.Borrow;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Integer> {

	
}
