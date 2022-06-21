package com.cognixia.jump.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Vehicle;
import com.cognixia.jump.repository.VehicleRepository;

@RestController
@RequestMapping("/api")
public class VehicleController {
	
	@Autowired
	VehicleRepository repo;
	
	@GetMapping("/vehicle")
	public List<Vehicle> getVehicles() {
		return repo.findAll();
	}

	@GetMapping("/vehicle/{id}")
	public ResponseEntity<?> getVehicle(@PathVariable int id) {
		
		Optional<Vehicle> found = repo.findById(id);
		
		if (found.isEmpty()) {
			return ResponseEntity.status(404)
					 .body("Vehicle with id =" + id + " not found");
		}
		else {
			return ResponseEntity.status(200)
					 .body(found.get());
		}
	}
	
	@PostMapping("/vehicle")
	public ResponseEntity<?> createVehicle(@RequestBody Vehicle car) {
		
		car.setId(null);
		
		Vehicle created = repo.save(car);
		
		return ResponseEntity.status(201).body(created);
	}
	
	@DeleteMapping("/vehicle/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable int id) {
		
		boolean exists = repo.existsById(id);
		
		if (exists) {
			repo.deleteById(id);
			
			return ResponseEntity.status(200).body("Vehicle was deleted");
		}
		else {
			return ResponseEntity.status(404).body("Can't delete, Vehicle doesn't exists");
		}
	}
	
	@PutMapping("/vehicle")
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle car) {
		
		boolean exists = repo.existsById(car.getId());
		
		if(exists) {
			Vehicle updated = repo.save(car);
			return ResponseEntity.status(200)
					 .body(updated);
		}
		else {
			return ResponseEntity.status(404)
					 .body("Can't perfom update, student doesn't exist");
		}
	}
	
	@PatchMapping("/vehicle/color")
	public ResponseEntity<?> updateColor(@PathParam(value = "id") int id, @PathParam(value = "color") String color) {
		Optional<Vehicle> found = repo.findById(id);
		
		
		if(!found.isEmpty()) {
			Vehicle updated = found.get();
			
			updated.setColor(color);
			
			repo.save(updated);
			
			return ResponseEntity.status(200)
					 .body("Color of vehicle was changed");
		}
		else {
			return ResponseEntity.status(404)
					 .body("Can't perfom update, vehicle doesn't exist");
		}
	}
	
	@PatchMapping("/vehicle/mileage")
	public ResponseEntity<?> updateMileage(@PathParam(value = "id") int id, @PathParam(value = "mileage") String mileage) {
		Optional<Vehicle> found = repo.findById(id);
		
		
		if(!found.isEmpty()) {
			Vehicle updated = found.get();
			
			updated.setMileage(mileage);
			
			repo.save(updated);
			
			return ResponseEntity.status(200)
					 .body("Mileage for vehicle was changed");
		}
		else {
			return ResponseEntity.status(404)
					 .body("Can't perfom update, vehicle doesn't exist");
		}
	}

	@PatchMapping("/vehicle/accident")
	public ResponseEntity<?> updateAccident(@PathParam(value = "id") int id, @PathParam(value = "accident") Boolean accident) {
		Optional<Vehicle> found = repo.findById(id);
		
		
		if(!found.isEmpty()) {
			Vehicle updated = found.get();
			
			updated.setAccident(accident);
			
			repo.save(updated);
			
			return ResponseEntity.status(200)
					 .body("Accident status for vehicle was changed");
		}
		else {
			return ResponseEntity.status(404)
					 .body("Can't perfom update, vehicle doesn't exist");
		}
	}

	@PatchMapping("/vehicle/preowned")
	public ResponseEntity<?> updatePreOwned(@PathParam(value = "id") int id, @PathParam(value = "preowned") Boolean preOwned) {
		Optional<Vehicle> found = repo.findById(id);
		
		
		if(!found.isEmpty()) {
			Vehicle updated = found.get();
			
			updated.setPreOwned(preOwned);
			
			repo.save(updated);
			
			return ResponseEntity.status(200)
					 .body("PreOwned status for vehicle was changed");
		}
		else {
			return ResponseEntity.status(404)
					 .body("Can't perfom update, vehicle doesn't exist");
		}
	}

}
