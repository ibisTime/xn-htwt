package com.cdkj.loan.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdkj.loan.dao.IInterviewVideoDAO;
import com.cdkj.loan.dao.base.support.AMybatisTemplate;
import com.cdkj.loan.domain.InterviewVideo;



//CHECK 。。。 
@Repository("interviewVideoDAOImpl")
public class InterviewVideoDAOImpl extends AMybatisTemplate implements IInterviewVideoDAO {


	@Override
	public int insert(InterviewVideo data) {
		return super.insert(NAMESPACE.concat("insert_interviewVideo"), data);
	}


	@Override
	public int delete(InterviewVideo data) {
		return super.delete(NAMESPACE.concat("delete_interviewVideo"), data);
	}


	@Override
	public InterviewVideo select(InterviewVideo condition) {
		return super.select(NAMESPACE.concat("select_interviewVideo"), condition,InterviewVideo.class);
	}


	@Override
	public long selectTotalCount(InterviewVideo condition) {
		return super.selectTotalCount(NAMESPACE.concat("select_interviewVideo_count"),condition);
	}


	@Override
	public List<InterviewVideo> selectList(InterviewVideo condition) {
		return super.selectList(NAMESPACE.concat("select_interviewVideo"), condition,InterviewVideo.class);
	}


	@Override
	public List<InterviewVideo> selectList(InterviewVideo condition, int start, int count) {
		return super.selectList(NAMESPACE.concat("select_interviewVideo"), start, count,condition, InterviewVideo.class);
	}


}