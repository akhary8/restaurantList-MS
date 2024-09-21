package com.example.restaurantListing.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restaurantListing.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

}
