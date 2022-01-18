/**
 * 
 */
package com.ibm.cars.controller;

import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.Entity.PreUploadAnnrt;
import com.ibm.cars.Exception.DataNotFound;
import com.ibm.cars.Exception.Exceptions;
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
	@GetMapping("pre_upld_audit")
	public ResponseEntity<List<PreUploadAnnrt>> preUpldAudit(@RequestParam(value="mcn", required=true) String mcn) {
		List<PreUploadAnnrt> mcnData=	mcnService.preUpldAudit(mcn);
		if(mcnData.isEmpty()) {
			throw new DataNotFound("No data found for the requested MCN's");
		}
		return ResponseEntity.ok(mcnData);

	}
}