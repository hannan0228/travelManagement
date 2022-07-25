package com.travel.spring_aop.code.repository;

import org.springframework.data.repository.CrudRepository;

import com.travel.spring_aop.code.models.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
