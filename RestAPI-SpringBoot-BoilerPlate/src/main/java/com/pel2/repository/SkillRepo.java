/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pel2.repository;

import com.pel2.dto.Skill;
import java.io.Serializable;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author JOSEPH
 */
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "skill", viewName = "all")
//This annotation is necessary to prevent a 'bean error'
@Service
public interface SkillRepo extends CouchbaseRepository<Skill, Integer>{  
    
}
