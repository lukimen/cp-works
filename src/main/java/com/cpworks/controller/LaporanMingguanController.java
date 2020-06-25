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

import java.util.List;

@RestController
@RequestMapping("cp-works/laporan-mingguan")
@Api(value = "laporan-mingguan Controller")
public class LaporanMingguanController {

	@Autowired
	private LaporanService laporanService;

	@ApiOperation(value = "laporan-mingguan", notes = "get laporan-mingguan")
	@GetMapping
	public BaseResponse<Laporan> getLaporanMingguan(
			@RequestParam(required = true) String tahunAwal,
			@RequestParam(required = true) String mingguAwal,
			@RequestParam(required = true) String tahunAkhir,
			@RequestParam(required = true) String mingguAkhir) {

		Laporan result = laporanService.getLaporanMingguan(
				tahunAwal,
				mingguAwal,
				tahunAkhir,
				mingguAkhir);

		return BaseResponse.<Laporan>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

}