package com.Guest.Controller;

import java.util.List;
import java.util.Optional;

import com.Guest.Service.GuestserviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Guest.Models.Guest;
import com.Guest.Models.GuestList;
import com.Guest.Service.Guestservice;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/Guest")
public class GuestController {

	@Autowired
	GuestserviceImpl guestService;

	@GetMapping("/hello")
	public String test() {
		return "Hello Guest!!";
	}

	@PostMapping("/addGuest")
	public Guest addGuest(@RequestBody Guest guest) {
		return this.guestService.addGuest(guest);
	}

//	@PutMapping("/updateGuest")
//	public Guest updateGuest(@RequestBody Guest guest) {
//		return this.guestService.updateGuest(guest);
//	}
	@PutMapping("/updateGuest/{id}")
	public ResponseEntity < Object > updateGuest(@PathVariable String id, @RequestBody Guest guest) {
		try {
			guest.setGuestId(Integer.parseInt(id));
			return ResponseEntity.ok().body(guestService.updateGuest(guest));
		}
		catch(Exception e)
		{
			return new ResponseEntity<>("User not found with id"+id, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteGuest/{id}")
	public String deleteGuestById(@PathVariable("id") String id)  {
		return this.guestService.deleteGuest(Integer.parseInt(id));
	}


	@GetMapping("getGuest/{id}")
	public Optional<Guest> getGuest(@PathVariable String id) {
		return this.guestService.getGuest(Integer.parseInt(id));
	}

	@GetMapping("getAllGuest")
    List<Guest> GuestList(){
		return guestService.getAllGuest();
	}

	}


