package com.Room;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import com.Room.Models.Room;
import com.Room.Repository.RoomMongodbRepos;
import com.Room.Service.Roomservice;
@RunWith(SpringRunner.class)
@SpringBootTest
class RoomMicroserviceApplicationTests {
		@Autowired
		private Roomservice roomservice;

		@MockBean
		private RoomMongodbRepos roomMongodbRepos;

		@Test
		public void getRoomTest(){
			when(roomMongodbRepos.findAll()).thenReturn(Stream.of(new Room(105L,400,"1BHK","Small",true), new Room(520L,1000,"2BHK","Big",false)).collect(Collectors.toList()));
			assertEquals(2, roomservice.getAllRoom().size());
		}

		@Test
		public void saveRoomTest(){
			Room room = new Room(109L,1000,"2BHK","Small",false);
			when(roomMongodbRepos.save(room)).thenReturn(room);
			assertEquals(room,roomservice.updateRoom(room));
		}

		@Test
		public void deleteRoomTest(){
			Room room = new Room(109L,1000,"2BHK","Small",false);
			roomservice.deleteRoom(109L);
			verify(roomMongodbRepos, times(1)).deleteById(109L);
		}

	/*@Test
	void contextLoads() {
	}*/

	}

