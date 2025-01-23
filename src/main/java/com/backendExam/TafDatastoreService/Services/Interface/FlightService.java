package com.backendExam.TafDatastoreService.Services.Interface;

import com.backendExam.TafDatastoreService.Models.Flight;

import java.util.List;

public interface FlightService {
    Flight add(Flight flight);

    List<Flight> getAll();

    Flight get(Long id);

    Flight update(Long id,Flight flight);

    void delete(Long id);
}
