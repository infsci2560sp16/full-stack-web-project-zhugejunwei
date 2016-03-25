/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todoapp;
 
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.bson.types.ObjectId;

import java.util.Date;
 /**
 *
 * @author zhugejunwei
 */
public class Todo {
 
    private String id;
    private String title;
    private boolean done;
    private Date createdOn = new Date();
 
    public Todo(BasicDBObject dbObject) {
        this.id = ((ObjectId) dbObject.get("_id")).toString();
        this.title = dbObject.getString("title");
        this.done = dbObject.getBoolean("done");
        //this.createdOn = dbObject.getDate("createdOn");
    }
 
    public String getTitle() {
        return title;
    }
 
    public boolean isDone() {
        return done;
    }
 
    public Date getCreatedOn() {
        return createdOn;
    }
}
