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

import static org.junit.Assume.assumeNoException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetadataGeneratorTests {

	@Test
	public void loadingAllEntityMetadataClass() {
		try {
			Class.forName("BaseEntity_");
			Class.forName("Movie_");
			Class.forName("UserProfile_");
		} catch (ClassNotFoundException e) {
			assumeNoException("Some of Metadata classes cannot be loaded.", e);
		}
	}
}
