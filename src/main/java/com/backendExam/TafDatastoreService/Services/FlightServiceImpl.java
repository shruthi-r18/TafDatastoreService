package com.backendExam.TafDatastoreService.Services;

import com.backendExam.TafDatastoreService.Models.Flight;
import com.backendExam.TafDatastoreService.Repositories.FlightRepository;
import com.backendExam.TafDatastoreService.Services.Interface.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight add(Flight flight) {return this.flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAll() {
        return this.flightRepository.findAll();
    }

    @Override
    public Flight get(Long id) {
        return this.flightRepository.findById(id).orElse(null);
    }

    @Override
    public Flight update(Long id, Flight flight) {
        if (this.flightRepository.existsById(id)) {
            flight.setFlightId(id);
            return this.flightRepository.save(flight);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        this.flightRepository.deleteById(id);
    }
}