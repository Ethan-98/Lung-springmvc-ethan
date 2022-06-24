package backend.announce.service;

import java.util.List;

import backend.announce.model.AnnounceBean;

public interface AnnounceService {

			//show all
			public List<AnnounceBean> getAnnounce();
			
			//save
			public void saveAnnounce(AnnounceBean theAnnounceBean);
			
			//getOrder
			public AnnounceBean getAnnounceBean(Integer anNo);
			
			//delete
			public void deleteAnnounce(Integer anNo);
}
