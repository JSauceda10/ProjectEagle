/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pel2.dto;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author JOSEPH
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Skill {
    @Id
    private int id;
    @Field
    private String name;
    @Field
    private int level;
    @Field
    private String language;
    
    public enum EnumPlatform 
    { 
        DISTRIBUTED, MAINFRAME; 
    }
    @Field
    EnumPlatform platform;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
