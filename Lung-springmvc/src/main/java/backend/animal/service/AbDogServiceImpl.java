package backend.animal.service;
import java.util.List;
import backend.animal.bean.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.animal.dao.AbDogDao;

import java.util.List;
@Service

public class AbDogServiceImpl implements AbDogService {
    @Autowired
    private AbDogDao abdogdao;

	@Override
    @Transactional

	public List<AbDogBean> getAbDog() {
		return abdogdao.getAbDog();
	}

	@Override
    @Transactional

	public void saveAbDog(AbDogBean abdogbean) {
		abdogdao.saveAbDog(abdogbean);
		
	}

	@Override
	@Transactional
	public AbDogBean getAbDogById(int Id) {
		return abdogdao.getAbDogById(Id);
	}

	@Override
    @Transactional

	public void deleteAbDog(int Id) {	
		abdogdao.deleteAbDog(Id);
	}

}
