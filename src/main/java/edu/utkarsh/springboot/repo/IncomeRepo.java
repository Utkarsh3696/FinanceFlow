package edu.utkarsh.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utkarsh.springboot.dto.Income;

@Repository
public interface IncomeRepo extends JpaRepository<Income, Integer> {

}
