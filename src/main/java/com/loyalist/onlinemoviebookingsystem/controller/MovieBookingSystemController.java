package com.loyalist.onlinemoviebookingsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loyalist.onlinemoviebookingsystem.dao.IUserRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Booking;
import com.loyalist.onlinemoviebookingsystem.dto.Cinema;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHall;
import com.loyalist.onlinemoviebookingsystem.dto.CinemaHallSeat;
import com.loyalist.onlinemoviebookingsystem.dto.Movie;
import com.loyalist.onlinemoviebookingsystem.dto.Show;
import com.loyalist.onlinemoviebookingsystem.dto.User;
import com.loyalist.onlinemoviebookingsystem.request.AuthRequest;
import com.loyalist.onlinemoviebookingsystem.request.CinemaHallSeatRequestVO;
import com.loyalist.onlinemoviebookingsystem.request.ShowRequestVO;
import com.loyalist.onlinemoviebookingsystem.response.CinemaHallResponseVO;
import com.loyalist.onlinemoviebookingsystem.response.ShowResponseVO;
import com.loyalist.onlinemoviebookingsystem.service.IAuthenticationService;
import com.loyalist.onlinemoviebookingsystem.service.IBookingService;
import com.loyalist.onlinemoviebookingsystem.service.ICinema;
import com.loyalist.onlinemoviebookingsystem.service.ICinemaHall;
import com.loyalist.onlinemoviebookingsystem.service.ICinemaHallSeat;
import com.loyalist.onlinemoviebookingsystem.service.IMovie;
import com.loyalist.onlinemoviebookingsystem.service.IShow;
import com.loyalist.onlinemoviebookingsystem.service.JWTService;
import com.loyalist.onlinemoviebookingsystem.service.UserServiceImpl;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
public class MovieBookingSystemController {

	@Autowired
	IMovie movieService;

	@Autowired
	ICinema cinemaService;

	@Autowired
	ICinemaHall cinemaHallService;

	@Autowired
	ICinemaHallSeat cinemaHallSeatService;

	@Autowired
	IShow showService;

	@Autowired
	IBookingService bookingService;

	@Autowired
	UserServiceImpl userDetailsService;

	@Autowired
	JWTService jwtService;

	@Autowired
	IUserRepository userRepository;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	IAuthenticationService authenticationService;


	@PostMapping("/authenticate/user")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getUserPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid Username and password. Please try again");

		}

	}
	
	//hello this is prabhjot

	// kafka demo for producer

	/*
	 * @GetMapping("/publish/{message}")
	 * 
	 * public ResponseEntity<?> publicMessage(@PathVariable String message) { for
	 * (int i = 0; i < 1000; i++) { publisher.sendMessage(message); } return
	 * ResponseEntity.ok("message published successfully"); }
	 */
	
	
	

	// user
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {

		userDetailsService.addUser(user);
		return new ResponseEntity<String>("message sent", HttpStatus.CREATED);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userDetailsService.getUsers(), HttpStatus.OK);
	}

	@GetMapping("/getUserById/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable long userId) {
		return new ResponseEntity<User>(userDetailsService.getUserById(userId), HttpStatus.OK);
	}

	@PostMapping("/updateUser/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable long userId, @RequestBody User user) {
		return new ResponseEntity<User>(userDetailsService.updateUser(userId, user), HttpStatus.OK);
	}

	// movie

	@PostMapping("/addMovie")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.addMovie(movie), HttpStatus.OK);
	}

	@GetMapping("/movies")
	public ResponseEntity<List<Movie>> getMovies() {
		return new ResponseEntity<List<Movie>>(movieService.getMovies(), HttpStatus.OK);
	}

	@PutMapping("/updateMovie/{movieId}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long movieId, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(movieService.updateMovie(movieId, movie), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteMovie/{movieId}")
	public ResponseEntity<List<Movie>> deleteMovie(@PathVariable long movieId) {
		return new ResponseEntity<List<Movie>>(movieService.deleteMovie(movieId), HttpStatus.OK);
	}

	// cinema

	@PostMapping("/addCinema")
	public ResponseEntity<String> addCinema(@RequestBody Cinema cinema) {
		return new ResponseEntity<String>(cinemaService.addCinema(cinema), HttpStatus.CREATED);
	}

	@GetMapping("/getCinema")
	public ResponseEntity<List<Cinema>> getCinema() {
		return new ResponseEntity<List<Cinema>>(cinemaService.getCinemas(), HttpStatus.OK);
	}

	@GetMapping("/getCinemaByCinemaId/{cinemaId}")
	public ResponseEntity<Cinema> getCinemaByCinemaId(@PathVariable long cinemaId) {
		return new ResponseEntity<Cinema>(cinemaService.getCinemaByCinemaId(cinemaId), HttpStatus.OK);
	}

	@PostMapping("/updateCinemaDetails/{cinemaId}")
	public ResponseEntity<String> updateCinemaDetails(@PathVariable long cinemaId, @RequestBody Cinema cinema) {
		return new ResponseEntity<String>(cinemaService.updateCinemaDetails(cinemaId, cinema), HttpStatus.OK);
	}

	// cinemaHall

	@PostMapping("/{cinemaId}/addCinemaHall")
	public ResponseEntity<String> addCinemaHall(@PathVariable long cinemaId, @RequestBody CinemaHall cinemaHall) {
		return new ResponseEntity<String>(cinemaHallService.addCinemaHall(cinemaId, cinemaHall), HttpStatus.OK);
	}

	@GetMapping("/getCinemaHall/{cinemaId}")
	public ResponseEntity<List<CinemaHallResponseVO>> getCinemaHalls(@PathVariable long cinemaId) {
		return new ResponseEntity<List<CinemaHallResponseVO>>(cinemaHallService.getCinemaHalls(cinemaId),
				HttpStatus.OK);
	}

	// cinemaHallSeats

	@PostMapping("/{cinemaId}/{cinemaHallId}/addCinemaHallSeat")
	public ResponseEntity<String> addCinemaHallSeat(@PathVariable long cinemaId, @PathVariable long cinemaHallId,
			@RequestBody CinemaHallSeatRequestVO cinemaHallSeatRequestVO) {
		return new ResponseEntity<String>(
				cinemaHallSeatService.addCinemaHallSeat(cinemaId, cinemaHallId, cinemaHallSeatRequestVO),
				HttpStatus.OK);

	}

	@GetMapping("/{cinemaId}/{cinemaHallId}/getCinemaHallSeat")
	public ResponseEntity<List<CinemaHallSeat>> getCinemaHallSeat(@PathVariable long cinemaId,
			@PathVariable long cinemaHallId) {
		return new ResponseEntity<List<CinemaHallSeat>>(cinemaHallSeatService.getCinemaHallSeat(cinemaId, cinemaHallId),
				HttpStatus.OK);
	}

	// Show

	@PostMapping("/movie/cinema/cinemaHall/addShow")
	public ResponseEntity<String> addShow(@Valid @RequestBody ShowRequestVO showRequestVO) {
		return new ResponseEntity<String>(showService.addShow(showRequestVO), HttpStatus.OK);
	}

	@GetMapping("/getAllShows")
	public ResponseEntity<List<Show>> getAllShows() {
		return new ResponseEntity<List<Show>>(showService.getShows(), HttpStatus.OK);
	}

	@GetMapping("/findShowsByMovieId/{movieId}")
	public ResponseEntity<List<ShowResponseVO>> getShowsByMovieName(@PathVariable long movieId) {
		return new ResponseEntity<List<ShowResponseVO>>(showService.getShowsByMovieId(movieId), HttpStatus.OK);
	}

	@GetMapping("/findShowsByCinemaAndCinemaHall/{cinemaId}/{cinemaHallId}")
	public ResponseEntity<List<ShowResponseVO>> getShowsByCinemaAndCinemaHall(@PathVariable long cinemaId,
			@PathVariable long cinemaHallId) {
		return new ResponseEntity<List<ShowResponseVO>>(
				showService.getShowsByCinemaAndCinemaHall(cinemaId, cinemaHallId), HttpStatus.OK);
	}

	@GetMapping("/findShowByShowId/{showId}")
	public ResponseEntity<Show> getShowByShowId(@PathVariable long showId) {
		return new ResponseEntity<Show>(showService.getShowById(showId), HttpStatus.OK);
	}

	// showSeat

	/*
	 * @PostMapping("/{movieId}/{cinemaHallId}")
	 */

	// Booking

	@PostMapping("/{userId}/{showId}/addBooking")
	public ResponseEntity<String> addBooking(@PathVariable long userId, @PathVariable long showId,
			@RequestBody Booking booking) {
		return new ResponseEntity<String>(bookingService.addBooking(userId, showId, booking), HttpStatus.OK);
	}

}
