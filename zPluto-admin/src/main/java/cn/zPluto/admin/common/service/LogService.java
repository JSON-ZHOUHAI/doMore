package cn.zPluto.admin.common.service;


import cn.zPluto.admin.common.domain.LogDO;
import cn.zPluto.admin.common.domain.PageDO;
import cn.zPluto.admin.common.utils.Query;
import org.springframework.stereotype.Service;

@Service
public interface LogService {
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
