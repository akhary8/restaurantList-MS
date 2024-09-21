package com.example.restaurantListing.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restaurantListing.dto.RestaurantDTO;
import com.example.restaurantListing.entity.Restaurant;
import com.example.restaurantListing.mapper.RestaurantMapper;
import com.example.restaurantListing.repo.RestaurantRepo;

@Service
public class RestaurantService {
	
	@Autowired
	RestaurantRepo restaurantRepo;

	public List<RestaurantDTO> findAllRestaurants() {
		List<Restaurant> restaurants=restaurantRepo.findAll();
		//map the each restaurant detail to restaurantDTO using java 8 map fun
		List<RestaurantDTO> restaurantDTOList	=restaurants.stream().map(restaurant-> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
		return restaurantDTOList;
	}

	public RestaurantDTO addRestaurantInDb(RestaurantDTO restaurantDTO) {
		// TODO Auto-generated method stub
	Restaurant savedRestaurant=restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
		return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant); 
	}

	public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Restaurant>restaurant= restaurantRepo.findById(id);
		if (restaurant.isPresent()) {
			return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		
		
		
		
	}
	
	

}
