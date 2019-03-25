/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web_connector;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Kamil
 */
public class GetId {
    
    public String getIdFromJson(String answer){
        
            JSONObject obj = new JSONObject(answer);    
            String id = obj.getJSONArray("Dataobject").getJSONObject(0).getString("id");
            System.out.println(id);
            return id;
    }
    
}
