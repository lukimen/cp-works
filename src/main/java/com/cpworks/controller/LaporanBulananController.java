package com.cpworks.controller;

import com.cpworks.dao.Laporan;
import com.cpworks.dao.LaporanService;
import com.cpworks.model.BaseResponse;
import com.cpworks.model.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cp-works/laporan-bulanan")
@Api(value = "laporan-bulanan Controller")
public class LaporanBulananController {

	@Autowired
	private LaporanService laporanService;

	@ApiOperation(value = "laporan-bulanan", notes = "get laporan-bulanan")
	@GetMapping
	public BaseResponse<Laporan> getLaporanBulanan(
			@RequestParam(required = true) String tahunAwal,
			@RequestParam(required = true) String bulanAwal,
			@RequestParam(required = true) String tahunAkhir,
			@RequestParam(required = true) String bulanAkhir) {

		Laporan result = laporanService.getLaporanBulanan(
				tahunAwal,
				bulanAwal,
				tahunAkhir,
				bulanAkhir);

		return BaseResponse.<Laporan>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

}