package com.ibm.cars.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.Repository.AnnualRateRepository;
import com.ibm.cars.bean.PreUpldAuditRequestBean;
import com.ibm.cars.dao.AnnualRateDao;
import com.ibm.cars.utility.CommonUtilityFile;

/**
 * @author 002SUJ744
 *
 */
@Service
public class AddRatesDaoImpl implements AnnualRateDao {

	@Autowired
	AnnualRateRepository repository;
	

	
	@Autowired
	CommonUtilityFile commonUtilityFile ;
	
	public AddRatesDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<PreUploadAnnrt> getAllMcns(){	
	return	repository.findAll();	
	}
//	This method is used to get the mcn data from pre_upload_annrt table 
	public List<PreUploadAnnrt> getMcn(String mcn) throws Exception{	
		Optional<PreUploadAnnrt> mcnData;
		List<PreUploadAnnrt> mcnArray = new ArrayList<PreUploadAnnrt>();
		try {
		mcnData = repository.findById(mcn);
		System.out.println("the data -->"+mcnData);
		if(mcnData.isEmpty()) {
			throw new Exception(commonUtilityFile.mcnDataError());
		}
		mcnArray.add(mcnData.get());
		}catch (Exception e) {
			throw new Exception(commonUtilityFile.mcnDataError());
		}
		return mcnArray; 
	}

	@Override
	public void savePreUploadAnnrt(PreUploadAnnrt preupload) throws Exception {
		// TODO Auto-generated method stub
		repository.save(preupload);
		
	}
	@Override
	public void deleteMcn(String mcn)throws Exception{
		repository.deleteById(mcn);
	}
		
}
