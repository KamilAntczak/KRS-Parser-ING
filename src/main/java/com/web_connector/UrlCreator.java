/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web_connector;

import java.net.URISyntaxException;
import org.apache.http.client.utils.URIBuilder;

/**
 *
 * @author Kamil
 */
public class UrlCreator {
    
    public URIBuilder build_url(String key, String value) throws URISyntaxException{
        
        URIBuilder builder = new URIBuilder("https://api-v3.mojepanstwo.pl/dane/krs_podmioty.json");
        builder.setParameter(key, value);
        
        return builder;
    }
    
    
}
