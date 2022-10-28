package com.example.User.controllers;
import com.example.User.models.Guest;
import com.example.User.models.Room;
import com.example.User.models.User;
import com.example.User.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        try {
            User _user = userService.addUser(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("User could not be added", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/findAllUser")
    public List<User> getUser() {

        return userService.getAllUsers();
    }
    @GetMapping("Userlist/{id}")
    public ResponseEntity <Object> getUserById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(userService.getUserById(id));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity < Object > updateSupplier(@PathVariable String id, @RequestBody User user) {
        try {
            user.setId(id);
            return ResponseEntity.ok().body(userService.updateUser(user));
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteSupplier(@PathVariable String id)  {
        try {
            userService.deleteUser(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>("User not found with id"+id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/ViewGuest/{name}")
    public Guest getGuest(@PathVariable String id){
        Guest guest = restTemplate.getForObject("http://localhost:8089/Guest/getGuest/" + id, Guest.class);
        return guest;
    }

    @GetMapping("/ListAllGuests")
    public List<Guest> getAllDrugs()
    {
        Guest[] guests = restTemplate.getForObject("http://localhost:8089/Guest/getallGuest", Guest[].class);
        List<Guest> guest = Arrays.asList(guests);
        return guest;
    }

    @PostMapping("/AddRoom")
    public ResponseEntity<Room> createOrder(@RequestBody Room room) throws RestClientException, JsonProcessingException {
       return restTemplate.postForEntity("http://localhost:8086/rooms/addRoom", room, Room.class);

    }

}

