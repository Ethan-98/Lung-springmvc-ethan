package backend.member.service;

import java.util.List;

import backend.member.model.MemberBean;

public interface MemberService {
	
	//show all
	public List<MemberBean> findAll();
	
	//save
	public void saveMember(MemberBean theMemberBean);
	
	//getOrder
	public MemberBean findById(Integer mi_no);
	
	//delete
	public void deleteMember(Integer mi_no);
	
}
