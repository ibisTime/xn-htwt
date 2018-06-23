package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IBusBorrowDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.BusBorrow;



//CHECK 。。。 
@Repository("busBorrowDAOImpl")
public class BusBorrowDAOImpl extends AMybatisTemplate implements IBusBorrowDAO {


	@Override
	public int insert(BusBorrow data) {
		return super.insert(NAMESPACE.concat("insert_busBorrow"), data);
	}


	@Override
	public int delete(BusBorrow data) {
		return super.delete(NAMESPACE.concat("delete_busBorrow"), data);
	}


	@Override
	public BusBorrow select(BusBorrow condition) {
		return super.select(NAMESPACE.concat("select_busBorrow"), condition,BusBorrow.class);
	}


	@Override
	public long selectTotalCount(BusBorrow condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_busBorrow_count"),condition);
	}


	@Override
	public List<BusBorrow> selectList(BusBorrow condition) {
		return super.selectList(NAMESPACE.concat("select_busBorrow"), condition,BusBorrow.class);
	}


	@Override
	public List<BusBorrow> selectList(BusBorrow condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_busBorrow"), start, count,condition, BusBorrow.class);
	}


}