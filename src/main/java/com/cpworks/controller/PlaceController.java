package com.cpworks.controller;

import com.cpworks.dao.OrderDao;
import com.cpworks.dao.OrderDaoService;
import com.cpworks.dao.PlaceDao;
import com.cpworks.dao.PlaceDaoService;
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
@RequestMapping("cp-works/place")
@Api(value = "c Controller")
public class PlaceController {

	@Autowired
	private PlaceDaoService placeDaoService;

	@ApiOperation(value = "Place", notes = "get Place")
	@GetMapping("/by-place-type")
	public BaseResponse<List<PlaceDao>> getPlace(
			@RequestParam(required = true) String email) {

		List<PlaceDao> result = placeDaoService.findByType(email);

		return BaseResponse.<List<PlaceDao>>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

}