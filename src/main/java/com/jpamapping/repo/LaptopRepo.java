package com.jpamapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpamapping.entity.Laptop;

@Repository
public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
