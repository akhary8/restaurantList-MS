package com.example.restaurantListing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restaurantListing.dto.RestaurantDTO;
import com.example.restaurantListing.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {
	
	@Autowired
	RestaurantService restaurantService;
	
	@GetMapping("/fetchAllRestaurants")
	public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
		
	List<RestaurantDTO>  allRestaurants =    restaurantService.findAllRestaurants();
	return new ResponseEntity<>(allRestaurants,HttpStatus.OK);
		
	}
	
	@PostMapping("/addRestaurant")
	public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
		
		RestaurantDTO restaurantAdded= restaurantService.addRestaurantInDb(restaurantDTO);
		return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/fetchById/{id}")
	public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Integer id) {
		
	
	return restaurantService.fetchRestaurantById(id);
	}
	
	
	

}
