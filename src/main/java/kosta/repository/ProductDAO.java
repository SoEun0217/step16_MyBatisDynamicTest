package kosta.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.ProductListDTO;

public class ProductDAO {
	/**
	 * 레코드 삽입 
	 * */
	public static boolean insert(ProductListDTO dto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.insert("dynamicMapper.insert", dto)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return state;
	}
	
	/**
	 * 레코드 검색
	 * */
	public static List<ProductListDTO> select(String field,String keyword,String order){
		SqlSession session = null;
		List<ProductListDTO>list = null;
		Map<String, String>map = new HashMap<String, String>();
		map.put("field", field);
		map.put("keyword", keyword);
		map.put("order",order);
		try {
			session = DbUtil.getSession();
			list = session.selectList("dynamicMapper.dynamicSelect", map);
		} finally {
			DbUtil.sessionClose(session);
		}
		return list;
	}
	
	/**
	 * 수정하기
	 * */
	public static boolean update(ProductListDTO dto) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("dynamicMapper.update", dto)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return state;
	}
	
	/**
	 * 삭제하기
	 * */
	public static boolean delete(String code) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.delete("dynamicMapper.delete", code)>0?true:false;
		} finally {
			DbUtil.sessionClose(session, state);
		}
		return state;
	}
	
	/**
	 * 모든 상품의 개수 출력하기
	 * */
	public static int selectSum() {
		SqlSession session = null;
		int result;
		try {
			session = DbUtil.getSession();
			result = session.selectOne("dynamicMapper.selectSum");
		} finally {
			DbUtil.sessionClose(session);
		}
		return result;
	}
	
	/**
	 * 코드가 포함된 레코드 검색
	 * */
	public static List<ProductListDTO>selectCode(List<String>list){
		SqlSession session = null;
		List<ProductListDTO>result = null;
		try {
			session = DbUtil.getSession();
			result = session.selectList("dynamicMapper.selectCode", list);
		} finally {
			DbUtil.sessionClose(session);
		}
		return result;
	}
	
}
