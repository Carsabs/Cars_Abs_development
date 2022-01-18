package com.ibm.cars.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.Repository.AnnualRateRepository;
import com.ibm.cars.dao.AnnualRateDao;

/**
 * @author 002SUJ744
 *
 */
@Service
public class AddRatesDaoImpl implements AnnualRateDao {

	@Autowired
	AnnualRateRepository repository;
	
	public AddRatesDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public List<PreUploadAnnrt> getAllMcns(){	
	return	repository.findAll();	
	}
//	This method is used to get the mcn data from pre_upload_annrt table 
	public List<PreUploadAnnrt> getMcn(String mcn){	
		Optional<PreUploadAnnrt> mcnData;
		List<PreUploadAnnrt> mcnArray = new ArrayList<PreUploadAnnrt>();
		try {
		mcnData = repository.findById(mcn);
		System.out.println("the data -->"+mcnData);
		if(mcnData.isEmpty()) {
			// throw error message
		}
		mcnArray.add(mcnData.get());
		}catch (Exception e) {
			//throw error message
		}
		return mcnArray; 
	}
		
}
