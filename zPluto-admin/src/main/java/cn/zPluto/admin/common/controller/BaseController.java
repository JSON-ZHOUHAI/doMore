package cn.zPluto.admin.common.controller;


import cn.zPluto.admin.common.utils.ShiroUtils;
import cn.zPluto.admin.system.domain.UserDO;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}