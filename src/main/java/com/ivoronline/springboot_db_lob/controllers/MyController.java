package com.ivoronline.springboot_db_lob.controllers;

import com.ivoronline.springboot_db_lob.entities.PersonEntity;
import com.ivoronline.springboot_db_lob.respositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  @ResponseBody
  @RequestMapping("/AddPerson")
  public String addPerson() throws IOException {

    //READ FILE
    Path         filePath                 = Path.of("src/main/resources/Test.txt");
    byte[]       fileContent              = Files.readAllBytes(filePath);

    //CREATE PERSON ENTITY
    PersonEntity personEntity             = new PersonEntity();
                 personEntity.name        = "John";
                 personEntity.age         = 20;
                 personEntity.description = fileContent;               //STORE FILE

    //STORE PERSON ENTITY
    personRepository.save(personEntity);

    //READ PERSON ENTITY
    PersonEntity personEntity1 = personRepository.findById(1).get();
    byte[]       fileContent1  = personEntity1.description;            //READ FILE

    //RETURN FILE CONTENT
    return new String(fileContent1);

  }

}
