package com.backendExam.TafDatastoreService.Services.Interface;

import com.backendExam.TafDatastoreService.Models.Booking;

import java.util.List;

public interface BookingService {
    Booking add(Booking booking);

    List<Booking> getAll();

    Booking get(Long id);

    Booking update(Booking booking);

    Booking delete(Long id);

    List<Booking> getByUserId(Long userId);
}
