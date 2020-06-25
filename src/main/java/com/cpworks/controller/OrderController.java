package com.cpworks.controller;

import com.cpworks.dao.OrderDao;
import com.cpworks.dao.OrderDaoService;
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
@RequestMapping("cp-works/order")
@Api(value = "Order Controller")
public class OrderController {

	@Autowired
	private OrderDaoService orderDaoService;

	@ApiOperation(value = "Order", notes = "get Order")
	@GetMapping("/by-email")
	public BaseResponse<List<OrderDao>> getOrder(
			@RequestParam(required = true) String email) {

		List<OrderDao> result = orderDaoService.getOrder(email);

		return BaseResponse.<List<OrderDao>>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

	@ApiOperation(value = "Pesan", notes = "pesan office/meeting")
	@GetMapping("/pesan")
	public BaseResponse<Boolean> pesan(
			@RequestParam(required = true) String placeId,
			@RequestParam(required = true) String tanggalAwalSewa,
			@RequestParam(required = true) String email,
			@RequestParam(required = true) int durasiSewa,
			@RequestParam(required = true) double totalBayar) {

		boolean pesanBerhasil = orderDaoService.pesan(
				placeId, tanggalAwalSewa, email, durasiSewa, totalBayar);

		return BaseResponse.<Boolean>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(pesanBerhasil)
				.build();
	}

}