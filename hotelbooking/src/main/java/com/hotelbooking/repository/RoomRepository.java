/**
 * 
 * @author manishanikambe
 * Room Repository for all database operations 
 */
package com.hotelbooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotelbooking.entity.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {


}
