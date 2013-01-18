package org.zetta1985.framework.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * @author t_hara
 */
public class PaginatedCodeScrap {

	@Test
	public void page_1() {
		int allCount = 10;
		int rows = 3;
		assertTrue(allCount % rows > 0);
		assertEquals(4, allCount / rows + 1);
		
		int page = 1;
		assertEquals(1, rows * page - rows + 1);
		assertEquals(3, rows * page);
		
		page = 2;
		assertEquals(4, rows * page - rows + 1);
		assertEquals(6, rows * page);
		
		page = 3;
		assertEquals(7, rows * page - rows + 1);
		assertEquals(9, rows * page);
		
		page = 4;
		int end = rows * page;
		if (end > allCount) {
			end = allCount;
		}
		assertEquals(10, rows * page - rows + 1);
		assertEquals(10, end);
	}
	
	@Test
	public void page_2() {
		int allCount = 10;
		int rows = 2;
		assertTrue(allCount % rows == 0);
		assertEquals(5, allCount / rows);
		
		int page = 1;
		assertEquals(1, rows * page - rows + 1);
		assertEquals(2, rows * page);
		
		page = 2;
		assertEquals(3, rows * page - rows + 1);
		assertEquals(4, rows * page);
		
		page = 3;
		assertEquals(5, rows * page - rows + 1);
		assertEquals(6, rows * page);
		
		page = 4;
		assertEquals(7, rows * page - rows + 1);
		assertEquals(8, rows * page);
		
		page = 5;
		int end = rows * page;
		if (end > allCount) {
			end = allCount;
		}
		assertEquals(9, rows * page - rows + 1);
		assertEquals(10, end);
	}
	
	public void page_3() {
		int allCount = 10;
		int rows = 4;
		assertTrue(allCount % rows > 0);
		assertEquals(3, allCount / rows + 1);
		
		int page = 1;
		assertEquals(1, rows * page - rows + 1);
		assertEquals(4, rows * page);
		
		page = 2;
		assertEquals(5, rows * page - rows + 1);
		assertEquals(8, rows * page);
		
		page = 3;
		int end = rows * page;
		if (end > allCount) {
			end = allCount;
		}
		assertEquals(9, rows * page - rows + 1);
		assertEquals(10, end);
	}
}
