package com.springdoctor;

import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<DoctorController.Doctor, Integer> {

}
