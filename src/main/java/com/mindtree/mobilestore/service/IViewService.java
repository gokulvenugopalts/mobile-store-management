package com.mindtree.mobilestore.service;

import java.util.ArrayList;

import com.mindtree.mobilestore.entity.Display;
import com.mindtree.mobilestore.entity.User;

public interface IViewService {
	public String viewService(User user);
	public String viewServiceByName(User user);
	public String viewServiceByCost(User user);
}
