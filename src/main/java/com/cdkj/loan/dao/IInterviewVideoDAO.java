package com.cdkj.loan.dao;

import com.cdkj.loan.dao.base.IBaseDAO;
import com.cdkj.loan.domain.InterviewVideo;

//dao层 
public interface IInterviewVideoDAO extends IBaseDAO<InterviewVideo> {
	String NAMESPACE = IInterviewVideoDAO.class.getName().concat(".");
}