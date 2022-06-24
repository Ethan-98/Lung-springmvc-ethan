package backend.activity.dao;

import java.util.List;

import backend.activity.model.ActivityBean;


public interface ActivityDao {
	
	//show all
	public List<ActivityBean> getActivity();
	
	//save
	public void saveActivity(ActivityBean theActivityBean);
	
	//getOrder
	public ActivityBean getActivityBean(Integer ac_id);
	
	//delete
	public void deleteActivity(Integer ac_id);
}
