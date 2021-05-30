/**
 * @author manishanikambe
 * Message Consumer which will cosnumer message sent to Rabbit MQ
 */
package com.hotelbooking.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotelbooking.entity.Room;
import com.hotelbooking.services.RoomService;

@Component
public class RoomCleanerListener {

	private static final Logger logger = LoggerFactory.getLogger(RoomCleanerListener.class);
	private static final String ROOM = "ROOM";
	private final ObjectMapper objectMapper;
	private final RoomService roomService;

	public RoomCleanerListener(ObjectMapper objectMapper, RoomService roomService) {
		this.objectMapper = objectMapper;
		this.roomService = roomService;
	}

	public void receiveMessage(String message) {
		try {
			AsyncPayload payload = objectMapper.readValue(message, AsyncPayload.class);
			if (ROOM.equals(payload.getModel())) {
				Room room = roomService.getById(payload.getId());
				logger.info("ROOM {}:{} needs to be cleaned", room.getRoomNumber(), room.getRoomName());
			} else {
				logger.warn("unknown model type");
			}
		} catch (JsonProcessingException e) {
			logger.error("Exception occured in receiveMessage:" + e);
		}
	}

}
