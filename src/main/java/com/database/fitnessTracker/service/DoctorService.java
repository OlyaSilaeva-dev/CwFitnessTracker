//package com.database.fitnessTracker.service;
//
//import com.database.fitnessTracker.Exceptions.UnknownDoctorException;
//import com.database.fitnessTracker.entity.Doctors;
//import com.database.fitnessTracker.entity.ServicesDoctors;
//import com.database.fitnessTracker.repository.DoctorRepository;
//import com.database.fitnessTracker.repository.ServiceDoctorsRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@AllArgsConstructor
//public class DoctorService {
//
//    private final ServiceDoctorsRepository serviceDoctorsRepository;
//
//    private final SrvcService srvcService;
//
//    private final DoctorRepository doctorRepository;
//
//    public List<Doctors> findByServiceId(int serviceId) {
//        return serviceDoctorsRepository.getServicesDoctorsByServiceId(srvcService.findById(serviceId).orElseThrow(UnknownDoctorException::new))
//                .stream()
//                .map(ServicesDoctors::getDoctorId)
//                .toList();
//    }
//
//    public Optional<Doctors> findById(int id) {
//        return doctorRepository.findById(id);
//    }
//}
