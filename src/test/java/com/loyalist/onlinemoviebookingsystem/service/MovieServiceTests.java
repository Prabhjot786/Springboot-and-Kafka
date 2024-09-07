package com.loyalist.onlinemoviebookingsystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.loyalist.onlinemoviebookingsystem.dao.IMovieRepository;
import com.loyalist.onlinemoviebookingsystem.dto.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovieServiceTests {

	@MockBean
	IMovieRepository movieRepository;

	@Autowired
	MovieService movieService;

	@Test
	public void getMoviesTest() {
		when(movieRepository.findAll()).thenReturn(Stream.of(new Movie("Inception",
                "A mind-bending thriller about dreams within dreams.",
                148,
                new String[]{"English", "Japanese", "French"},
                LocalDateTime.of(2010, 7, 16, 0, 0),
                "USA",
                "Sci-Fi"),new Movie("Inception 2",
                        "A mind-bending thriller about dreams within dreams.",
                        148,
                        new String[]{"English", "Japanese", "French"},
                        LocalDateTime.of(2010, 7, 16, 0, 0),
                        "USA",
                        "Sci-Fi")).collect(Collectors.toList()));
		assertEquals(1, movieService.getMovies().size());
	}

}
