package backend.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.activity.dao.ActivityDao;
import backend.activity.model.ActivityBean;
import backend.activity.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDao ActivityDao;
	@Override
	@Transactional
	public List<ActivityBean> getActivity() {
		return ActivityDao.getActivity();
	}

	@Override
	@Transactional
	public void saveActivity(ActivityBean theActivityBean) {
		ActivityDao.saveActivity(theActivityBean);
	}

	@Override
	@Transactional
	public ActivityBean findById(Integer ac_id) {
		return ActivityDao.getActivityBean(ac_id);
	}

	@Override
	@Transactional
	public void deleteActivity(Integer ac_id) {
		ActivityDao.deleteActivity(ac_id);
	}

}
