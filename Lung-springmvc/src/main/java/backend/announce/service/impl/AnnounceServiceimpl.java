package backend.announce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.announce.dao.AnnounceDao;
import backend.announce.model.AnnounceBean;
import backend.announce.service.AnnounceService;

@Service
@Transactional
public class AnnounceServiceimpl implements AnnounceService {
	
	@Autowired
	private AnnounceDao AnnounceDao;
	
	@Override
	public List<AnnounceBean> getAnnounce() {
		return AnnounceDao.getAnnounce();
	}

	@Override
	public void saveAnnounce(AnnounceBean theAnnounceBean) {
		AnnounceDao.saveAnnounce(theAnnounceBean);
	}

	@Override
	public AnnounceBean getAnnounceBean(Integer anNo) {
		return AnnounceDao.getAnnounceBean(anNo);
	}

	@Override
	public void deleteAnnounce(Integer anNo) {
		AnnounceDao.deleteAnnounce(anNo);
	}

}
