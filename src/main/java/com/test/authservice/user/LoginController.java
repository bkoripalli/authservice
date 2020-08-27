package com.test.authservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.authservice.user.domain.Login;
import com.test.authservice.user.domain.User;

@RestController
public class LoginController {

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> loginUser(@RequestBody Login login) {
		if (!login.getUsername().contentEquals(login.getPassword())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return new ResponseEntity<User>(new User("Test", "Angular"), HttpStatus.OK);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Hello SPringBoot!!";
	}
}
