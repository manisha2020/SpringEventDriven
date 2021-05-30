/**
 * 
 * @author manishanikambe
 * Rest Controller class exposing rest apis
 */
package com.hotelbooking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.entity.Room;
import com.hotelbooking.services.RoomService;


@RestController
public class HotelBookingController {

	@Autowired
	private RoomService roomService;
	
	/**
	 * Returns list of all available rooms 
	 * @return
	 */
	@RequestMapping(value = "/rooms" , method = RequestMethod.GET)
	public List<Room> getRooms()
	{
		return roomService.getRooms();
	}
}

