package ctv.com.app.common.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ctv.com.app.common.bean.PublisherBean;
import ctv.com.app.common.dao.BaseDao;
import ctv.com.app.common.logic.BaseLogicIF;

@Service("baseLogic")
public class BaseLogicImpl implements BaseLogicIF{
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public String getMessage(int id) throws Throwable{
		PublisherBean publisher = new PublisherBean();
		publisher.setId(id);
		publisher = baseDao.selectPublisherById(publisher);
		String hello = "Hello " + publisher.getName();
		
		for (int i= 4; i< 8;i++) {
			PublisherBean p = new PublisherBean();
			p.setId(i);
			p.setName("P" + i);
			boolean isInsertd = baseDao.insertPublisher(p);
			if (!isInsertd){
				throw new Throwable();
			}
		}
		return hello;
	}
}
