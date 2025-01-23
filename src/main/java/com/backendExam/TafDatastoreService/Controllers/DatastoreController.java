package com.backendExam.TafDatastoreService.Controllers;

import com.backendExam.TafDatastoreService.Models.Booking;
import com.backendExam.TafDatastoreService.Models.Flight;
import com.backendExam.TafDatastoreService.Models.User;
import com.backendExam.TafDatastoreService.Services.BookingServiceImpl;
import com.backendExam.TafDatastoreService.Services.FlightServiceImpl;
import com.backendExam.TafDatastoreService.Services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class DatastoreController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private FlightServiceImpl flightServiceImpl;

    @Autowired
    private final BookingServiceImpl bookingServiceImpl;

    public DatastoreController(BookingServiceImpl bookingServiceImpl) {
        this.bookingServiceImpl = bookingServiceImpl;
    }


    //    User ms
    @PostMapping("/users/register")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userServiceImpl.add(user), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userServiceImpl.get(id), HttpStatus.OK);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updatedUser = userServiceImpl.update(id, user);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //  Flight ms
    @PostMapping("/flights")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return new ResponseEntity<>(flightServiceImpl.add(flight), HttpStatus.CREATED);
    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flightServiceImpl.getAll(), HttpStatus.OK);
    }

    @GetMapping("/flights/{id}")
    public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
        Flight flight = flightServiceImpl.get(id);
        if (flight != null) {
            return new ResponseEntity<>(flight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/flights/{id}")
    public ResponseEntity<Flight> updateFlight(@PathVariable Long id, @RequestBody Flight flight) {
        Flight updatedFlight = flightServiceImpl.update(id, flight);
        if (updatedFlight != null) {
            return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id) {
        flightServiceImpl.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    Booking ms


    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        return new ResponseEntity<>(bookingServiceImpl.add(booking), HttpStatus.CREATED);
    }

    @GetMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long bookingId) {
        Booking booking = bookingServiceImpl.get(bookingId);
        if (booking != null) {
            return new ResponseEntity<>(booking, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bookings/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUser(@PathVariable Long userId) {
        List<Booking> bookings = bookingServiceImpl.getByUserId(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId) {
        Booking bookings = bookingServiceImpl.delete(bookingId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}
