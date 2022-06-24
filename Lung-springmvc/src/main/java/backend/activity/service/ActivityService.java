package backend.activity.service;

import java.util.List;

import backend.activity.model.ActivityBean;

public interface ActivityService {
	
	//show all
		public List<ActivityBean> getActivity();
		
		//save
		public void saveActivity(ActivityBean theActivityBean);
		
		//getOrder
		public ActivityBean findById(Integer ac_id);
		
		//delete
		public void deleteActivity(Integer ac_id);
	
}
