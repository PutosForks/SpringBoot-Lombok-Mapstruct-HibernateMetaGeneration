/*
 * Copyright 2018 SpringBoot-Lombok-Mapstruct-HibernateMetaGeneration
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ronlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ronlam.test.dto.MovieDto;
import com.ronlam.test.dto.UserProfileDto;
import com.ronlam.test.mapper.MovieMapper;
import com.ronlam.test.mapper.UserProfileMapper;
import com.ronlam.test.model.Movie;
import com.ronlam.test.model.UserProfile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapStructTests {

	@Inject
	private UserProfileMapper userProfileMapper;
	
	@Inject
	private MovieMapper movieMapper;
	
	@Test
	public void mapperGeneration() {
		assertNotNull( "UserProfileMapper is null.", userProfileMapper);
		assertNotNull("MovieMapper is null.", movieMapper);
	}

	@Test
	public void toDtoFunction() {
		UserProfile user = new UserProfile();
		user.setId(1l);
		user.setFirstName("Test First Name");
		user.setFirstName("Test Last Name");
		
		UserProfileDto dto = userProfileMapper.toDto(user);
		
		assertEquals(user.getId(), dto.getId());
		assertEquals(user.getFirstName(), dto.getFirstName());
		assertEquals(user.getLastName(), dto.getLastName());
	}
	
	@Test
	public void toEntityFunction() {
		MovieDto movie = new MovieDto();
		movie.setId(2l);
		movie.setName("Test Movie Name");
		movie.setReleaseDate(LocalDate.of(2018, 1, 1));
		
		Movie entity = movieMapper.toEntity(movie);
		
		assertEquals(movie.getId(), entity.getId());
		assertEquals(movie.getName(), entity.getName());
		assertEquals(movie.getReleaseDate(), entity.getReleaseDate());
	}
}
