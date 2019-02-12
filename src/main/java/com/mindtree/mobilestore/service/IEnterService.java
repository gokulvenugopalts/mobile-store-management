package com.mindtree.mobilestore.service;


import com.mindtree.mobilestore.entity.Mobile;
import com.mindtree.mobilestore.entity.User;

public interface IEnterService {
	public String enterService(User user, Mobile mobObj);
	public String getOperList();
}
