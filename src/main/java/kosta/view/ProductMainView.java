package kosta.view;

import java.util.Arrays;

import kosta.dto.ProductListDTO;
import kosta.repository.ProductDAO;

public class ProductMainView {
  public static void main(String[] args) {
	  /**
	   * [1]. 레코드 삽입
	   * */
	  System.out.println("********** [1] 상품 등록하기 ******************");
	  //ProductDAO.insert(new ProductListDTO("A06", "초코송이", 8, 1000, "초코송이냠냠"));
	  
	  /**
	   * [2].   ex) select * from productList
	   *         ex)  select * from productList where 검색필드 like  검색단어
	   *          ex) select *from productList order by 정렬대상
	   *          ex) select * from productList where 검색필드 like  검색단어  order by 정렬대상
	   * */
	  System.out.println("********** [2] 모든 게시물 검색 또는 조건에 따른 검색 및 정렬 ******************");
	  System.out.println(ProductDAO.select("name", "깡", null));
	  System.out.println(ProductDAO.select(null, null, "qty"));
	  System.out.println(ProductDAO.select("name", "깡", "qty"));
	 
	  /**
	   * [3].  parameter 정보에 따라 레코드 수정한다.
	   *     상품코드에 해당하는 상품의 
	   *     상품이름, 상품수량, 상품가격, 상품상세정보를 수정하데 parameter 의 정보가 있는 데이터만 수정한다.
	   * 
	   * */
	  System.out.println("********** [3] 상품 수정하기 ******************");
	  boolean result = false;
	  //result = ProductDAO.update(new ProductListDTO("A01", "수정됨", 2800, 0, "수정"));
	  result = ProductDAO.update(new ProductListDTO("A07", "수정됨", 2800, 0, "수정"));//존재하지않는것
	  if(result)EndView.message("수정완료되었다.");
	  else EndView.message("수정실패다.");
	  /**
	   * [4].상품코드에 해당하는 레코드 삭제
	   * */
	  System.out.println("********** [4] 상품 삭제하기 ******************");
	  boolean deleteResult = false;
	  deleteResult = ProductDAO.delete("A01");
	  if(deleteResult)EndView.message("삭제완료되었다.");
	  else EndView.message("삭제실패다.");
	 /**
	  * [5]. 모든 상품의 개수를 출력한다.

		  select sum(p_qty) from product -- 모든상품의 qty의총합계
	  * */
	  System.out.println("********** [5] 등록된 총 상품 개수 ******************");
	  System.out.println("등록된 총 개수"+ProductDAO.selectSum());


	  /**
	   * [6]. parameter의 상품코드에 해당하는 레코드 검색
	   * ex)select * from productList where in 상품코드 in (?,?,...)
	   * */
	  System.out.println("********** [6] 상품코드에 해당하는 레코드 검색 ******************");
	  System.out.println(ProductDAO.selectCode(Arrays.asList("A02","A06")));

}
}







