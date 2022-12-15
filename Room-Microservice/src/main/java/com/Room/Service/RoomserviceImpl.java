package com.Room.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Room.Models.Room;
import com.Room.Models.RoomList;
import com.Room.Repository.RoomMongodbRepos;

@Service
public class RoomserviceImpl implements Roomservice {

	@Autowired
	RoomMongodbRepos roomMongodbRepo;

	@Override
	public Room addRoom(Room room) {
		return roomMongodbRepo.insert(room);
	}

	@Override
	public Optional<Room> getRoom(long parseLong) {
		return roomMongodbRepo.findById(parseLong);
	}

	@Override
	public Room updateRoom(Room room) {
		return roomMongodbRepo.save(room);
	}

//	@Override
//	public String deleteRoom(long parseLong) {
//		roomMongodbRepo.deleteById(parseLong);
//		return "Room Number " + parseLong + " Deleted";
//	}
//	public String disableRoom(long parseLong) {
//		Optional<Room> op = roomMongodbRepo.findById(Long.valueOf(parseLong));
//		if (op.isPresent()) {
//			//userRepository.delete(op.get());
//			Room room = op.get();
//			if (room.isDeleted() == false) {
//				room.setDeleted(true);
//				roomMongodbRepo.save(room);
//			} else {
//				return null;
//			}
//		}
//	return null;
//}
	@Override
	public String deleteRoom(long parseLong) {
		roomMongodbRepo.deleteById(parseLong);
		return "Room Number " + parseLong + " Deleted";
	}

	@Override
	public List<Room> getAllRoom() {
		return roomMongodbRepo.findAll();
	}

	@Override
	public RoomList getRoomAvl() {
		RoomList list = new RoomList();
		list.setAllRoom(roomMongodbRepo.findAvailable());;
		return list;
	}

}