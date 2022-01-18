/**
 * 
 */
package com.ibm.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.Exception.DataNotFound;
import com.ibm.cars.bean.PreUpldAuditRequestBean;
import com.ibm.cars.service.McnService;

/**
 * @author 002SUJ744
 * 
 *         All the MCN related controllers will be available in this class
 *
 */

@RestController
@RequestMapping("mcn")
public class McnController {

	@Autowired
	McnService mcnService;

	@GetMapping("canaddmcn")
	public ResponseEntity<CanAddMcnEntity> canAddMCN() {
		CanAddMcnEntity canAddMCN = new CanAddMcnEntity();
		canAddMCN = mcnService.canAddMCN(canAddMCN);
		return ResponseEntity.ok(canAddMCN);

	}
	@PostMapping("pre_upld_audit")
	public ResponseEntity<List<PreUploadAnnrt>> preUpldAudit(@RequestBody PreUpldAuditRequestBean mcns) {
		List<PreUploadAnnrt> mcnData;
		try {
			mcnData = mcnService.preUpldAudit(mcns);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataNotFound(e.getMessage());
		}	
		return ResponseEntity.ok(mcnData);

	}
}