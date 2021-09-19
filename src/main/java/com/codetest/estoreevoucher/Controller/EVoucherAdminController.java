package com.codetest.estoreevoucher.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codetest.estoreevoucher.Enum.ActiveStatus;
import com.codetest.estoreevoucher.Model.EvoucherDTO;
import com.codetest.estoreevoucher.Service.EVoucherService;

@RestController
@RequestMapping("/admin")
public class EVoucherAdminController {

	@Autowired
	private EVoucherService evoucherService;

	@PostMapping(value = "/evouchers")
	public ResponseEntity<?> createEVoucher(EvoucherDTO evoucher) {
		try {
			evoucherService.createEvoucher(evoucher);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/evouchers")
	public ResponseEntity<?> updateEVoucher(EvoucherDTO evoucher) {
		try {
			evoucherService.updateEVoucher(evoucher);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

	@PutMapping("/evouchers/{id}/status/{status}")
	public ResponseEntity<?> updateEvoucherStatus(@PathVariable("id") long id,
			@PathVariable("status") ActiveStatus status) {
		EvoucherDTO evoucher = evoucherService.updateEvoucherStatus(id, status.toString());
		return ResponseEntity.ok(evoucher);
	}
}
