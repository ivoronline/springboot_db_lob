package com.ivoronline.springboot_db_lob.respositories;

import com.ivoronline.springboot_db_lob.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> { }
