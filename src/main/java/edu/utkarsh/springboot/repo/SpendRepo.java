package edu.utkarsh.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.utkarsh.springboot.dto.Spend;

@Repository
public interface SpendRepo extends JpaRepository<Spend, Integer> {

}
