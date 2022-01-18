package com.ibm.cars.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Configuration
@PropertySource(value = "classpath:common_utility.properties")
public class CommonUtilityFile{
	
    @Autowired
    private  Environment env ;

    public  String  canaddmcn_errorMessage() {
      return env.getProperty("error_message");
    }
    public  String  mcn_valid() {
        return env.getProperty("mcn_valid");
      }
	public String mcnDataError() {
		return env.getProperty("mcn_no_data_found");
	}
    
}