/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web_connector;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.rmi.server.ExportException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.http.client.utils.URIBuilder;

import org.json.*;

/**
 *
 * @author Kamil
 */
public class WebConnector  {
    
        ObjectMapper mapper = new ObjectMapper();
        CloseableHttpClient httpclient = HttpClients.createDefault();        
        GetId getId = new GetId();
    
    
    private String answer;
    
    public String get_data(URIBuilder builder) throws Exception{
           
         HttpGet httpGet = new HttpGet(builder.build());
           
        try(CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();             
            Object json = mapper.readValue(entity.getContent(), Object.class);                                 
            answer = mapper.writeValueAsString(json);
            answer = getId.getIdFromJson(answer);
          
        }
        catch (ExportException exception) {
                exception.getStackTrace();
        }
                           
        return answer;
    }
    
    public String get_full_data(String company_id)throws Exception{
        
        String url_part_one = "https://api-v3.mojepanstwo.pl/dane/krs_podmioty/";
        String url_part_two = ".json?layers[]=dzialalnosci&layers[]=reprezentacja&layers[]=emisje_akcji&layers[]=firmy&layers[]=komitetZalozycielski&layers[]=wspolnicy&layers[]=oddzialy&layers[]=jedynyAkcjonariusz&layers[]=prokurenci&layers[]=prokurenci";
        
        String url;
        
        url = new StringBuilder(url_part_one).append(company_id).append(url_part_two).toString();
        
        String a = "a"+company_id+ "b";
        System.out.println(url);
        
        HttpGet httpGet = new HttpGet(url);
        
        try(CloseableHttpResponse response = httpclient.execute(httpGet)) {
            HttpEntity entity = response.getEntity();             
            Object json = mapper.readValue(entity.getContent(), Object.class); 
            answer = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
            //answer = mapper.writeValueAsString(json);
            
            System.out.println(answer);
            
                               
            JSONObject obj = new JSONObject(answer);
            Set<String> s  = obj.keySet();
            
           for(String i: s){

               if(obj.isNull(i))
                   System.out.println("null");
               else
                System.out.println("not null");
           } 
            
            
            System.out.println(s.size());
        }
        catch (ExportException exception) {
                exception.getStackTrace();
        }
        
        return "";
    }
}
