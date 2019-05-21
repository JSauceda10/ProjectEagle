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
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author JOSEPH
 */
public class SkillController {
    @Autowired
    private SkillRepo skillRepo;
    
    @PostConstruct
    public void InitSkillRepo(){
        skillRepo.save(Stream.of(new Skill(1,"CouchBase"), new Skill(2,"SQL")).collect(Collectors.toList()));
    }
    @GetMapping("/allSkills")
    public Iterable<Skill> getAll(){
        return skillRepo.findAll();
        
    }
}
