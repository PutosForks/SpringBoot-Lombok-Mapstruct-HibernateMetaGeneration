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

import com.ronlam.test.dto.MovieDto;
import com.ronlam.test.dto.UserProfileDto;
import com.ronlam.test.service.MovieService;
import com.ronlam.test.service.UserProfileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@SpringBootApplication
public class TestApplication {

    public static void main(String[] args){
        SpringApplication.run(TestApplication.class, args);
    }
}

@Component
@Slf4j
@AllArgsConstructor
class AppRunner
    implements ApplicationRunner {

    private final UserProfileService userProfileService;

    private final MovieService movieService;

    @Override
    public void run(ApplicationArguments args){
        UserProfileDto
            userProfileDto = userProfileService.save(
                new UserProfileDto("Test", "Test2")
            );

        Object byId = userProfileService.findById(userProfileDto.getId());

        log.error("{}", byId);

        MovieDto movieDto = new MovieDto("Test movie", LocalDate.now());
        movieDto = movieService.save(movieDto);

        byId = movieService.findById(movieDto.getId());

        log.error("{}", byId);
    }
}







