package com.mds.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mds.demo.entities.Role;


@Controller
@RequestMapping(RoleController.BASE_ROUTE)
public class RoleController extends BaseCrudController<Role,Role>{
	
	public static final String TEMPLATE_NAME = "role";
	public static final String BASE_ROUTE = "role";
	
	public RoleController() {
		super(TEMPLATE_NAME);
		// TODO Auto-generated constructor stub
	}
}
