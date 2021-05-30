/**
 * 
 * @author manishanikambe
 * Service class for Room
 */
package com.hotelbooking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbooking.entity.Room;
import com.hotelbooking.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	/**
	 * returns all rooms from the database table
	 * Note: Not advisable to use findAll if you are working on large data sets
	 * @return
	 */
	public List<Room> getRooms()
	{
		List<Room> rooms = new ArrayList<>();
		  this.roomRepository.findAll().forEach(rooms::add);
		  return rooms;
	}
	
	/**
	 * returns room with given ID
	 * @return
	 */
	public Room getById(long id)
	{
		return roomRepository.findById(id).get();
		
	}
}
