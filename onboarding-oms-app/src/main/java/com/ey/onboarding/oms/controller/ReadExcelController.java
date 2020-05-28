package com.ey.onboarding.oms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import utils.ExcelReaderUtil;
import utils.PodListTO;
import utils.PodlistItemResponse;

@RestController
@RequestMapping("/api/v1")
public class ReadExcelController {

	@GetMapping("/get-all-pod-task-list")
	public PodlistItemResponse getAllItems() throws InvalidFormatException, IOException {

		PodlistItemResponse podlist = new PodlistItemResponse();
		podlist.setItemlist(ExcelReaderUtil.excelReaderMethod());

		return podlist;
	}

	@GetMapping("/get-specific-pod-task-list")
	public List<PodListTO> getPodElemet(@RequestParam(value = "podName") String podname)
			throws InvalidFormatException, IOException {

		List<PodListTO> podListTO1 = new ArrayList<PodListTO>();
		List<PodListTO> podListTO = ExcelReaderUtil.excelReaderMethod();

		for (PodListTO podItem : podListTO) {

			if (podItem.getPodName().equalsIgnoreCase(podname))
				podListTO1.add(podItem);
		}

		return podListTO1;
	}

}
