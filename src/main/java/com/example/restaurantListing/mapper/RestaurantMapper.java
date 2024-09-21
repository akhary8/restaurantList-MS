package com.example.restaurantListing.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.restaurantListing.dto.RestaurantDTO;
import com.example.restaurantListing.entity.Restaurant;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {
	
	
	//create a instance
	RestaurantMapper INSTANCE =Mappers.getMapper(RestaurantMapper.class);
	
	
	//create a abstract methods
	Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);
	
	RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

}
