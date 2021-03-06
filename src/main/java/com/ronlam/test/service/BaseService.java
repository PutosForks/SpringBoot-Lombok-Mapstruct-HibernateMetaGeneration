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

package com.ronlam.test.service;

import com.ronlam.test.dto.BaseDto;
import com.ronlam.test.mapper.BaseMapper;
import com.ronlam.test.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<E extends BaseEntity, D extends BaseDto> {
    JpaRepository<E, Long> getDao();
    BaseMapper<E, D> getMapper();

    D findById(Long id);
    D save(D dto);
}