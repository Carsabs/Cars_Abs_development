package com.ibm.cars.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.bean.PreUpldAuditRequestBean;
import com.ibm.cars.bean.PreUpldAuditResponseBean;
import com.ibm.cars.dao.AnnualRateDao;
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
	
	@Autowired
	AnnualRateDao annualRateDao;
	

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

	@Override
	public  List<PreUploadAnnrt>  preUpldAudit(PreUpldAuditRequestBean mcn) throws Exception {
		// TODO Auto-generated method stub
		PreUpldAuditResponseBean response = new PreUpldAuditResponseBean();
		PreUploadAnnrt mcnDatabean = new PreUploadAnnrt();
		List<PreUploadAnnrt> mcnDate = annualRateDao.getMcn(mcn.getMcn());
		System.out.println("the mcn data from request"+mcn);
		System.out.println("the mcn data from database"+mcnDate);
		if(mcnDate.isEmpty()) {
			System.out.println("no data in the database");
			// inserting the date if the mcn is not available
			mcnDatabean.setAction_code(mcn.getAction_code());
			mcnDatabean.setDate(new Date());
			mcnDatabean.setUserName(mcn.getUserName());
			mcnDatabean.setMcn(mcn.getMcn());
			annualRateDao.savePreUploadAnnrt(mcnDatabean);
		}else {
			PreUploadAnnrt mcnsingledata =mcnDate.get(0);
			if((mcnsingledata.getAction_code().equals("D") && mcn.getAction_code().equals("A"))
				|| (mcnsingledata.getAction_code().equals("C") && mcn.getAction_code().equals("D"))	
				) {
				System.out.println("inside the first if");
				if(mcnsingledata.getAction_code().equals("D")) {
					mcnDatabean.setAction_code("C");
					mcnDatabean.setDate(new Date());
					mcnDatabean.setUserName(mcn.getUserName());
					mcnDatabean.setMcn(mcn.getMcn());
					annualRateDao.savePreUploadAnnrt(mcnDatabean);
					System.out.println("updating the mcn data");
				}
			}else {
				  if (mcnsingledata.getAction_code().equals("A") && mcn.getAction_code().equals("D")) {
					  annualRateDao.deleteMcn(mcn.getMcn());
					  System.out.println("deleting the mcn data");
				  }
				
			}
		}
		
		
		return null;
	}

}
