
package com.sgic.internal.login.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.springframework.security.access.prepost.PreAuthorize;

import com.eureka.common.security.JwtConfig;

import com.sgic.internal.login.entities.ConfirmationToken;
import com.sgic.internal.login.entities.Email;
import com.sgic.internal.login.entities.Role;
import com.sgic.internal.login.entities.RoleName;
import com.sgic.internal.login.entities.User;
import com.sgic.internal.login.payload.UserProfile;
import com.sgic.internal.login.repositories.ConfirmationTokenRepository;
import com.sgic.internal.login.repositories.RoleRepository;
import com.sgic.internal.login.repositories.UserRepository;
import com.sgic.internal.login.request.LoginRequest;
import com.sgic.internal.login.request.SignUpForm;
import com.sgic.internal.login.response.JwtResponse;
import com.sgic.internal.login.response.ResponseMessage;
import com.sgic.internal.login.securityjwt.JwtProvider;
import com.sgic.internal.login.services.CurrentUser;
import com.sgic.internal.login.servicesimpl.NotificationService;
import com.sgic.internal.login.servicesimpl.UserDetailsServiceImpl;
import com.sgic.internal.login.servicesimpl.UserPrinciple;
import com.sgic.internal.login.servicesimpl.UserSummary;
import com.sgic.internal.login.util.AppConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	NotificationService notificationService;

	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;

	@Autowired
	JwtConfig jwtConfig;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		System.out.println("fffffffffffffffffffffffffffffffffffffff :" + loginRequest.getUsernameOrEmail()
				+ loginRequest.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		Long now = System.currentTimeMillis();
		String token = Jwts.builder().setSubject(authentication.getName())
				// Convert to list of strings.
				// This is important because it affects the way we get them back in the Gateway.
				.claim("authorities",
						authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(now)).setExpiration(new Date(now + jwtConfig.getExpiration() * 1000)) // in
																											// milliseconds
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes()).compact();
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername(), userDetails.getAuthorities(),
				userDetails.isEnabled()));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpRequest) {
//		Email email = new Email();
//		
//		email.setEmail(signUpRequest.getEmail());
//		email.setSubject("Username & Password");
//		email.setText("This is your Username:" + signUpRequest.getUsername()+"&&"+"This is your password:" + signUpRequest.getPassword());

//		notificationService.sendNotofication(email);

//		HttpHeaders headers = new HttpHeaders();
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<Email> entity = new HttpEntity<Email>(email, headers);
//		System.out.println("yes");
//		if(signUpRequest.getRole().equalsIgnoreCase("HR")) {
//		ResponseEntity<?> obj = restTemplate.exchange(AppConstants.SEND_EMAIL_URL,
//				HttpMethod.POST, entity, Email.class);
//		
//
//		System.out.println("obj" + obj);
//		
//		}
		System.out.println(
				"fffffffffffffffffffffffffffffffffffffff :" + signUpRequest.getEmail() + signUpRequest.getLastname()
						+ signUpRequest.getName() + signUpRequest.getPassword() + signUpRequest.getUsername());
//				+ signUpRequest.getRole() + 

		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getLastname(), signUpRequest.getUsername(),
				signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));

		String strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		switch (strRoles) {
		case "Admin":
			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: admin Role not find."));
			roles.add(adminRole);

			break;
		case "PM":
			Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: pm Role not find."));
			roles.add(pmRole);

			break;
		case "QA":
			Role qaRole = roleRepository.findByName(RoleName.ROLE_QA)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: qa Role not find."));
			roles.add(qaRole);

			break;
		case "Developer":
			Role devrole = roleRepository.findByName(RoleName.ROLE_DEVELOPER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: developer Role not find."));
			roles.add(devrole);

			break;
		case "HR":
			Role hrrole = roleRepository.findByName(RoleName.ROLE_HR)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: hr Role not find."));
			roles.add(hrrole);

			break;
		case "ProductAdmin":
			Role productrole = roleRepository.findByName(RoleName.ROLE_PRODUCT_ADMIN)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause:  productadmin Role not find."));
			roles.add(productrole);

			break;
		case "TecLead":
			Role techrole = roleRepository.findByName(RoleName.ROLE_TECH_LEAD)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause:  techlead Role not find."));
			roles.add(techrole);

			break;
		default:
			Role userRole = roleRepository.findByName(RoleName.ROLE_QA)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);
		}

		user.setRoles(roles);
		userRepository.save(user);

		Email email2 = new Email();
		email2.setEmail(user.getEmail());
		email2.setSubject("UserName & Password");
		email2.setText("This is your userName -" + " " + user.getUsername() + " OR " + user.getEmail() + "\n"
				+ "This is your Password -" + " " + signUpRequest.getPassword());

		HttpHeaders headers1 = new HttpHeaders();
		headers1.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Email> entity1 = new HttpEntity<Email>(email2, headers1);
		System.out.println("wwwwwwwwwwwwwww" + " " + email2.getEmail() + email2.getText());

		RestTemplate restTemplate = new RestTemplate();
		Email result = restTemplate.postForObject(AppConstants.SEND_EMAIL_URL, email2, Email.class);

		System.out.println(result);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}

//	@GetMapping("/user/me")
//    @PreAuthorize("hasRole('HR')")
//	public UserSummary getCurrentUser(@CurrentUser UserPrinciple currentUser) {
//		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
//				currentUser.getName());
//		return userSummary;
//	}

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('HR')")
	public UserSummary getCurrentUser(@CurrentUser UserPrinciple currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
		return userSummary;
	}

	@GetMapping("/user/admin")
	public UserSummary getCurrentAdmin(@CurrentUser UserPrinciple currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
				currentUser.getName());
		return userSummary;
	}

	@GetMapping("/users/{username}")
	public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username);

		UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getLastname(),
				user.getEmail(), user.getRoles());

		return userProfile;
	}

	@GetMapping("/getAllUsers")
	public List<User> getAllUserProfiles() {
		return userDetailsServiceImpl.getUserDetails();

	}

	@GetMapping("/getemail/{email}")
	public User getByEmail(@PathVariable(name = "email") String email) {
		return userDetailsServiceImpl.getByEmail(email);
	}

	@RequestMapping(value = "/forgotpassword/{email}", method = RequestMethod.GET)
	public ConfirmationToken forgotUserPassword(@PathVariable(name = "email") String email) {

		System.out.println(email);
		User existingUser = userDetailsServiceImpl.getByEmail(email);
		System.out.println(existingUser.getLastname());
		if (existingUser != null) {

			ConfirmationToken confirmationToken = new ConfirmationToken(existingUser);
			// save it
			confirmationTokenRepository.save(confirmationToken);

			Email email1 = new Email();
			email1.setEmail(email);
			email1.setSubject("Reset password");
			email1.setText(
					"To complete the password reset process, please click here: " + "http://localhost:3000/Reset");

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<Email> entity = new HttpEntity<Email>(email1, headers);
			System.out.println("yes");

			RestTemplate restTemplate = new RestTemplate();
			Email result = restTemplate.postForObject(AppConstants.SEND_EMAIL_URL, email1, Email.class);

			System.out.println(result);

//			Email obj = restTemplate.postForObject("http://localhost:8084/employeeservice/sendmail", email1, Email.class);

			return confirmationToken;

		}
		return null;
	}

	@RequestMapping(value = "/confirmreset/{token}", method = RequestMethod.GET)
	public User validateResetToken(@PathVariable(name = "token") String confirmationToken) {

		System.out.println(confirmationToken);
		ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		if (token != null) {
			User user = userRepository.findUserByEmail(token.getUser().getEmail());
			System.out.println(user.getLastname());

			User tokenUser = userRepository.findUserByEmail(user.getEmail());
			User password = userRepository.findUserById(tokenUser.getId());
			password.setName(user.getName());
			password.setPassword(encoder.encode(user.getPassword()));
//			

//			 RestTemplate restTemplate = new RestTemplate();
//			    User result = restTemplate.postForObject( "http://localhost:8085/resetpassword", password, User.class);
//			 
//			    System.out.println(result);

			return user;
//			userRepository.save(user);
//				modelAndView.addObject("user");
//				modelAndView.addObject("emailId", user.getEmail());
//				modelAndView.setViewName("resetPassword");
		}

		return null;
	}

	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	public User resetUserPassword(@RequestBody User user) {
		// ConfirmationToken token =
		// confirmationTokenRepository.findByConfirmationToken(confirmationToken);

		System.out.println(user.getRoles());

		User password = new User();
		password.setId(user.getId());
		password.setName(user.getName());
		password.setLastname(user.getLastname());
		password.setEmail(user.getEmail());
		password.setUsername(user.getUsername());
		password.setRoles(user.getRoles());
		password.setPassword(encoder.encode(user.getPassword()));
		userDetailsServiceImpl.updateUser(password);
//				modelAndView.addObject("message", "Password successfully reset. You can now log in with the new credentials.");
//				modelAndView.setViewName("successResetPassword");
//				return userDetailsServiceImpl.updateUser(user);

		return null;
	}

	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(userDetailsServiceImpl.getByuserId(id), HttpStatus.OK);
	}

	@PutMapping("userupdate/{id}")
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		userDetailsServiceImpl.updateUser(user);
		return null;
	}

	@DeleteMapping("/deletetoken/{tokenid}")
	public ResponseEntity<String> deletetokenId(@PathVariable("tokenid") Long tokenid) {
		userDetailsServiceImpl.deleteBytokenId(tokenid);
		return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	}


}
