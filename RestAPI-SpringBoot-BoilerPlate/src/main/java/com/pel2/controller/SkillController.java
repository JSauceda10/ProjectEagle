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
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        skillRepo.save(Stream.of(new Skill(1,"CouchBase",1,"java",Skill.EnumPlatform.DISTRIBUTED), new Skill(2,"SQL",1,"java",Skill.EnumPlatform.DISTRIBUTED)).collect(Collectors.toList()));
    }
    
    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void addSkill(@RequestBody Skill skill){
        skillRepo.save(skill);
    }
    
    
    //implement post and get methods
    //URL: http://127.0.0.1:9000/skills/(integer id goes here)
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public Skill getSkillById(@PathVariable("id") int id){
        return skillRepo.findOne(id);
        
    }
    
    //URL: http://127.0.0.1:9000/skills/allSkills
    @GetMapping("/allSkills")
    public Iterable<Skill> getAll(){
        return skillRepo.findAll();
        
    }
    
    @RequestMapping(
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{id}"
    )
    public void removeSkillById(@PathVariable("id") int id){
        skillRepo.delete(id);
        
    }
}
