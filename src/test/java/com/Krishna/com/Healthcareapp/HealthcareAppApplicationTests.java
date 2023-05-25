package com.Krishna.com.Healthcareapp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HealthcareAppApplicationTests {
    
	@Autowired
	private DoctorRepository DRepo;
	
	@Autowired
	private DoctorController DC;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testCreatemethod() {
		Doctor doctor =DRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		assertThat(doctor.getDoctorId()).isGreaterThan(0);
	}
	
	@Test
	public void testgetdetailsmethod() {
		Doctor doctor =DRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		Doctor DoctorlistById = DRepo.findById(doctor.getDoctorId()).get();
		assertThat(DoctorlistById).isNotNull();
	}
	
	@Test
	public void testgatalllistmethod() {
		Doctor doctor = new Doctor(101,"Krishna","Radiology",917781665);
		Doctor doctor1 = new Doctor(102,"Ramyasri","Cardiologist",799344758);
		Iterable<Doctor> Doctoralllist = DRepo.findAll();
		assertThat(Doctoralllist).isNotNull();
		assertThat(Doctoralllist.iterator()).isNotEqualTo(2);
	}
	
	
	@Test
	public void testupdatemethod() {
		Doctor doctor =DRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		Doctor saved =DRepo.findById(doctor.getDoctorId()).get();
		saved.setDmobileNo(950503279);
		saved.setDoctorName("Bhaskara");
		Doctor updatedetails = DRepo.save(saved);
		assertThat(updatedetails.getDmobileNo()).isEqualTo(950503279);
		assertThat(updatedetails.getDoctorName()).isEqualTo("Bhaskara");
	}
	
	@Test
	public void testdelete() {
		Doctor doctor = DRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		DRepo.deleteById(doctor.getDoctorId());
		Optional<Doctor> optionaldoctor = DRepo.findById(doctor.getDoctorId());
		assertThat(optionaldoctor).isEmpty();
	}
	
}
