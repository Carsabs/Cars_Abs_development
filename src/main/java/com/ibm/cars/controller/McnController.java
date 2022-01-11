/**
 * 
 */
package com.ibm.cars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cars.Entity.CanAddMcnEntity;
import com.ibm.cars.service.McnService;

/**
 * @author 002SUJ744
 * 
 *         All the MCN related controllers will be available in this class
 *
 */

@RestController("mcn")
public class McnController {

	@Autowired
	McnService mcnService;

	@GetMapping("canaddmcn")
	public ResponseEntity<CanAddMcnEntity> canAddMCN() {
		CanAddMcnEntity canAddMCN = new CanAddMcnEntity();
		canAddMCN = mcnService.canAddMCN(canAddMCN);
		return ResponseEntity.ok(canAddMCN);

	}
}