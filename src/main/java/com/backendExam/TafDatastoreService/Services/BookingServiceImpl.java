package com.backendExam.TafDatastoreService.Services;

import com.backendExam.TafDatastoreService.Models.Booking;
import com.backendExam.TafDatastoreService.Repositories.BookingRepository;
import com.backendExam.TafDatastoreService.Services.Interface.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking add(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAll() {
        return this.bookingRepository.findAll();
    }

    @Override
    public Booking get(Long id) {
        // Implement the logic to get a Booking by id
        return this.bookingRepository.findById(id).orElse(null);
    }
    @Override
    public List<Booking> getByUserId(Long userId) {
        return this.bookingRepository.findByUserId(userId);
    }

    @Override
    public Booking update(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    @Override
    public Booking delete(Long id) {
        Booking getBooking = this.bookingRepository.findById(id).orElse(null);
        getBooking.setStatus("Cancelled");
        return this.bookingRepository.save(getBooking);

    }


}
