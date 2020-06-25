package com.cpworks.controller;

import com.cpworks.dao.PlaceDao;
import com.cpworks.dao.PlaceDaoService;
import com.cpworks.model.BaseResponse;
import com.cpworks.model.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
			@RequestParam(required = true) String placeType) {

		List<PlaceDao> result = placeDaoService.findByType(placeType);

		return BaseResponse.<List<PlaceDao>>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

	@ApiOperation(value = "add Place", notes = "add Place")
	@PostMapping
	public BaseResponse<Boolean> addPlace(
			@RequestParam(required = true) String placeType,
			@RequestParam(required = true) String name,
			@RequestParam(required = true) String address,
			@RequestParam(required = true) String address2,
			@RequestParam(required = false) String image,
			@RequestParam(required = true) String durasi,
			@RequestParam(required = true) double price,
			@RequestParam(required = true) double latitude,
			@RequestParam(required = true) double longitude) {

		boolean result = placeDaoService.addPlace(
				placeType, name, address, address2, image, durasi, price, latitude, longitude);

		return BaseResponse.<Boolean>builder()
				.code(ResponseCode.SUCCESS.getCode())
				.data(result)
				.build();
	}

}