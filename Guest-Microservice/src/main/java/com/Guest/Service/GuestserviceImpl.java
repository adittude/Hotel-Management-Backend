package com.Guest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Guest.Models.Guest;
import com.Guest.Repository.GuestRepo;

@Service
public class GuestserviceImpl implements Guestservice {

	@Autowired
	GuestRepo guestRepo;

	@Override
	public Guest addGuest(Guest guest) {
		return guestRepo.insert(guest);
	}
	@Override
	public Guest updateGuest(Guest guest) {
		Optional<Guest> op = guestRepo.findById(guest.getGuestId());
		if (op.isPresent()) {
			Guest guest1 = op.get();
			guestRepo.save(guest);
			return guest;
		} else {
			return null;
		}
	}
//	@Override
//	public String deleteGuest(int id) {
//		guestRepo.deleteById(id);
//		return "Deleted Guest Id: " + id;
//	}
	public String disableGuest(int id) {
		Optional<Guest> op = guestRepo.findById(Integer.valueOf(id));
		if (op.isPresent()) {
			//userRepository.delete(op.get());
			Guest guest = op.get();
			if (guest.isDeleted() == false) {
				guest.setDeleted(true);
				guestRepo.save(guest);
			} else {
				return null;
			}
		}
		return null;
	}

	public String deleteGuest(int id){
		Optional<Guest> op = this.guestRepo.findById(id);
		if(op.isPresent()){
			this.guestRepo.delete(op.get());
		}
		return null;
	}
	@Override
	public Optional<Guest> getGuest(int id) {
		return guestRepo.findById(id);
	}

	@Override
	public List<Guest> getAllGuest() {
		return guestRepo.findAll();
	}

}
