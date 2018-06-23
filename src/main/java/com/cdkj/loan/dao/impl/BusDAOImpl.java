package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBusDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.Bus;



//CHECK 。。。 
@Repository("busDAOImpl")
public class BusDAOImpl extends AMybatisTemplate implements IBusDAO {


	@Override
	public int insert(Bus data) {
		return super.insert(NAMESPACE.concat("insert_bus"), data);
	}


	@Override
	public int delete(Bus data) {
		return super.delete(NAMESPACE.concat("delete_bus"), data);
	}


	@Override
	public Bus select(Bus condition) {
		return super.select(NAMESPACE.concat("select_bus"), condition,Bus.class);
	}


	@Override
	public long selectTotalCount(Bus condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_bus_count"),condition);
	}


	@Override
	public List<Bus> selectList(Bus condition) {
		return super.selectList(NAMESPACE.concat("select_bus"), condition,Bus.class);
	}


	@Override
	public List<Bus> selectList(Bus condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_bus"), start, count,condition, Bus.class);
	}


}