package com.itwill.my_real_korea.dao.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.my_real_korea.dto.City;
import com.itwill.my_real_korea.mapper.CityMapper;

@Repository
public class CityDaoImpl implements CityDao {
	
	@Autowired
	private CityMapper cityMapper;
	
	public CityDaoImpl() {
		System.out.println("CityDaoImp 기본생성자 호출");
	}

	@Override
	public int insertCity(City city) throws Exception {
		//시티새로추가
		return cityMapper.insertCity(city);
	}

	@Override
	public City findByCityNo(int cityNo) throws Exception {
		//시티번호로 시티찾기
		return cityMapper.findByCityNo(cityNo);
	}

	@Override
	public List<City> findAllCity() throws Exception {
		//시티리스트 전체 출력
		return cityMapper.findAllCity();
	}

}
