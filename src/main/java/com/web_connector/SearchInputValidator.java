/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.web_connector;
import com.graphic_interface.MainFrame;
        
        

/**
 *
 * @author Kamil
 */
public class SearchInputValidator {
    
    public boolean validate_input(String input, String key){
        
        
        switch(key){
            case "conditions[krs_podmioty.nip]": {
                
                return validate(10,input);
            }
            case "conditions[krs_podmioty.krs]": {
                
                return validate(10,input);
            }
            case "conditions[krs_podmioty.regon]": {
                
                return validate(9,input);
            }
            default: {
                return true;
            }
        }       
    }
    
    private boolean validate(int length, String input){
       
        if(input.length() == length || input.length() == 0)
            return true;
        else 
            return false;     
    }
    
}
