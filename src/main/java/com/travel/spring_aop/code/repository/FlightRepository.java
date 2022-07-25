package com.travel.spring_aop.code.repository;

import org.springframework.data.repository.CrudRepository;

import com.travel.spring_aop.code.models.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long> {

}
