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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ronlam.test.model.UserProfile;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LombokTests {
	
	private static Logger logger = LoggerFactory.getLogger(LombokTests.class);

	@Test
	public void callingLombokGeneratedFunction() {
		// all args constructor
		UserProfile user = new UserProfile("Test First Name", "Test Last Name");
		
		// using setters
		user.setId(1l);
		
		// using toString()
		logger.info("UserProfile created: " + user);
		
		// using getters
		assertEquals(user.getFirstName(), "Test First Name");
		assertEquals(user.getLastName(), "Test Last Name");
	}
}
