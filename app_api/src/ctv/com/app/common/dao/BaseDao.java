package ctv.com.app.common.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ctv.com.app.common.bean.PublisherBean;

@Repository("baseDao")
public class BaseDao {
	private String namespace;
	
	private static final String SELECT_PUBLISHER_BY_ID = "selectPublisherById";
	
	private static final String INSERT_PUBLISHER = "insertPublisher";
	
	@Autowired
	private SqlSessionTemplate appsSqlSession;
	
	public BaseDao() {
		setNamespace("ctv.com.app.common.dao.BaseDao");
	}
	
	public PublisherBean selectPublisherById(PublisherBean publisher) {
		String query = namespace + "." + SELECT_PUBLISHER_BY_ID;
		return appsSqlSession.selectOne(query, publisher);
	}
	
	public boolean insertPublisher(PublisherBean publisher) {
		String query = namespace +"." + INSERT_PUBLISHER;
		int result = appsSqlSession.insert(query, publisher);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
