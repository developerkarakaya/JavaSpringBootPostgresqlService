package com.springboot.start.lectureapi.controller;
import com.springboot.start.lectureapi.entity.User;
import com.springboot.start.lectureapi.entity.enums.Role;
import com.springboot.start.lectureapi.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService iUserService) {
        this.userService = iUserService;
    }

    @GetMapping
    ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/by-role")
    ResponseEntity<List<User>> getUsersByRole(@RequestParam Role role) {
        return  ResponseEntity.ok(userService.getUsersByRole(role));
    }

    @GetMapping("/{id}")
    ResponseEntity<User> getUserById(@PathVariable Integer id) {
        return  ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    ResponseEntity<User> createUser(@RequestBody User user) {
        return  ResponseEntity.ok(userService.Save(user));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteUsers(@PathVariable Integer id) {
        userService.delete(id);
          return ResponseEntity.ok().build();
    }

}
