package com.ibm.cars.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.service.McnService;
import com.ibm.cars.utility.CommonUtilityFile;
/**
 * @author 002SUJ744
 *
 */
@Service
public class McnServiceImpl implements McnService {

	public McnServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	CommonUtilityFile commonUtilityFile ;

	@Override
	public CanAddMcnEntity canAddMCN(CanAddMcnEntity entity) {
		// TODO Auto-generated method stub
		
		String mcn ="SOME";
		String mcnValue = "";
		String msg ="";
		if ((mcnValue!=null && mcnValue.length() > 0) || (mcn.equalsIgnoreCase("SOME"))) {
			entity.setMsg(commonUtilityFile.mcn_valid());
			entity.setValueptr(false);
			
		}else if(mcn == null && mcn.length() == 0) {
			entity.setValueptr(false);
			entity.setMsg(commonUtilityFile.canaddmcn_errorMessage());
		}
		
		 
		return entity;
	}

}
