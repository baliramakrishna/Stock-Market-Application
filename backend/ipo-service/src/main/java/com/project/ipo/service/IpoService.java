package com.project.ipo.service;

import com.project.ipo.model.IpoEntity;
import com.project.ipo.model.dto.IpoDTO;

public interface IpoService {
	IpoDTO getCompanyIPODetails(String company_name);
}
