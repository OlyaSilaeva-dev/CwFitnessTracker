package com.database.fitnessTracker.service;

import com.database.fitnessTracker.Exceptions.*;
import com.database.fitnessTracker.dto.Product.ProductDayProgressRequest;
import com.database.fitnessTracker.entity.Users;
import com.database.fitnessTracker.entity.Product;
import com.database.fitnessTracker.entity.DayProgress;
import com.database.fitnessTracker.repository.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Data
public class DayProgressProductService {
//    private final DayProgressRepository productDayProgressRepository;
//
//    private final ProductRepository productRepository;
//    private final UserRepository userRepository;
//    private final DayProgressRepository dayProgressRepository;


}
//public class BookingService {
//    private final BookingRepository bookingRepository;
//
//    private final UserService userService;
//    private final DoctorService doctorService;
//
//    private final SrvcService srvcService;
//    private final ServiceDoctorsRepository serviceDoctorsRepository;
//    private final JwtService jwtService;
//
//    public void save(Users booking) {
//        bookingRepository.save(booking);
//    }
//
//    public Optional<Users> findById(Integer id) {
//        return bookingRepository.findById(id);
//    }
//
//    public Iterable<Users> findAll() {
//        return bookingRepository.findAll();
//    }
//
//    public Page<Users> findAll(Pageable pageable) {
//        return bookingRepository.findAll(pageable);
//    }
//
//    public void deleteById(Integer id) {
//        bookingRepository.deleteById(id);
//    }
//
//    public void deleteAll() {
//        bookingRepository.deleteAll();
//    }
//
//    public void update(Integer id, Users booking) {
//        bookingRepository.save(booking);
//    }
//
//    public List<Users> findByDoctorId(Doctors doctor) {
//        return bookingRepository.findByDoctorId(doctor);
//    }
//
//    public List<Users> findByUserId(User user) {
//        return bookingRepository.findByUserId(user);
//    }
//
//    public List<Users> findBookingsByUserIdArchive() {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return bookingRepository.findBookingsByUserIdArchive(currentUser.getId());
//    }
//
//    public List<Users> findBookingsByUserIdRelevant() {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return bookingRepository.findBookingsByUserIdRelevant(currentUser);
//    }
//
//    public Users createBooking(BookingRequest bookingRequest) {
//        List<Users> DoctorBookings = bookingRepository
//                .findByDoctorId(doctorService.findById(bookingRequest.getDoctorId())
//                        .orElseThrow(UnknownDoctorException::new));
//        Doctors doctor = DoctorBookings.get(0).getDoctorId();
//        com.database.fitnessTracker.entity.Service service = srvcService
//                .findById(bookingRequest.getServiceId())
//                .orElseThrow(UnknownServiceException::new);
//        serviceDoctorsRepository.getServicesDoctorsByDoctorIdAndServiceId(doctor, service)
//                .orElseThrow(WrongDoctorException::new);
//        if (DoctorBookings.stream()
//                .anyMatch(booking -> booking.getDate().equals(bookingRequest.getDate()))) {
//            throw new DoctorIsBusyException();
//        }
//
//        if (bookingRequest.getDate().isBefore(LocalDateTime.now())) {
//            throw new WrongTimeException();
//        }
//
//        Users currentBooking = Users.builder()
//                .serviceId(srvcService.findById(bookingRequest.getServiceId()).orElseThrow(UnknownServiceException::new))
//                .userId(userService.findById(bookingRequest.getUserId()).orElse(null))
//                .doctorId(doctorService.findById(bookingRequest.getDoctorId()).orElseThrow(UnknownDoctorException::new))
//                .date(bookingRequest.getDate())
//                .build();
//
//        return bookingRepository.save(currentBooking);
//    }
//
//    public Users createBookingUser(BookingRequest bookingRequest) throws DoctorIsBusyException {
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        bookingRequest.setUserId(currentUser.getId());
//        return createBooking(bookingRequest);
//    }
//}
