/**
 * 
 * @author manishanikambe
 * Controller class to enable thymeleaf data display 
 */
package com.hotelbooking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hotelbooking.services.RoomService;

@Controller
public class RoomsThymeLeafController {

	@Autowired
	private RoomService roomService;
	
	/**
	 * Returns list of data of Rooms
	 * @param model
	 * 		maps object to ui
	 * @return
	 * 		any string
	 */
	@RequestMapping(value = "/roomsthymeleaf" , method = RequestMethod.GET)
	public String getAllRooms(Model model)
	{
		model.addAttribute("rooms", roomService.getRooms());
		return "rooms" ;
	}
	
	
	
}
