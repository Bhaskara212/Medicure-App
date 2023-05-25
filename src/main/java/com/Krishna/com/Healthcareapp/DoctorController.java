package com.Krishna.com.Healthcareapp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

	@Autowired
	DoctorRepository DRepo;
	
	@PostMapping("/register")
	public Doctor registerDoctor(@RequestBody Doctor doctor) {
		return DRepo.save(doctor);
	}
	
	@GetMapping("/getdetails/{doctorId}")
	public Doctor getdetails(@PathVariable(value="doctorId")int doctorId) {
		return DRepo.findById(doctorId).get();
	}
	
	@GetMapping({"/getalllist","/"})
	public Iterable<Doctor> getalllist(){
		return DRepo.findAll();
	}
	
	@PutMapping("/update/{doctorId}")
	public ResponseEntity<Object> updateDoctor(@RequestBody Doctor doctor,@PathVariable int doctorId){
		Optional<Doctor> doctorOptional = DRepo.findById(doctorId);
		if (doctorOptional.isEmpty())
			return ResponseEntity.notFound().build();
		doctor.setDoctorId(doctorId);
		DRepo.save(doctor);
		return ResponseEntity.noContent().build();
	
	}
	
	@DeleteMapping("/delete/{doctorId}")
	public void deleteDoctor(@PathVariable int doctorId) {
		 DRepo.deleteById(doctorId);
	}
	
}
