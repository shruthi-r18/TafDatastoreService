package com.backendExam.TafDatastoreService.Repositories;

import com.backendExam.TafDatastoreService.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
