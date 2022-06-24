package backend.announce.dao;

import java.util.List;

import backend.announce.model.AnnounceBean;

public interface AnnounceDao {

		//show all
		public List<AnnounceBean> getAnnounce();
		
		//save
		public void saveAnnounce(AnnounceBean theAnnounceBean);
		
		//get
		public AnnounceBean getAnnounceBean(Integer anNo);
		
		//delete
		public void deleteAnnounce(Integer anNo);

}
