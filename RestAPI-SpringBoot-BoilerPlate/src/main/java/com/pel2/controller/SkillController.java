/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pel2.controller;

import com.pel2.dto.Skill;
import com.pel2.repository.SkillRepo;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JOSEPH
 */
@RestController
@RequestMapping( value = "/skills")
public class SkillController {
    @Autowired
    public SkillRepo skillRepo;
    
    @PostConstruct
    public void InitSkillRepo(){
        skillRepo.save(Stream.of(new Skill(1,"CouchBase"), new Skill(2,"SQL")).collect(Collectors.toList()));
    }
    
    //implement post and get methods
    
    @GetMapping("/allSkills")
    public Iterable<Skill> getAll(){
        return skillRepo.findAll();
        
    }
}
