import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedTree {
/*
	@Test
	public void test() {
		LinkedTree tree = new LinkedTree();
		tree.insert(30, "this is the root");
		tree.insert(45, "this is one of 30's children");
		tree.insert(15, "this is another of 30's children");

		System.out.println(tree.search(45));
		assertTrue(tree.search(45).length()==1);
		
		tree.levelOrderPrint();
		System.out.println();
	}
	
	@Test
	public void testInsertKeys() {
		LinkedTree tree = new LinkedTree();
		int[] keys = {15, 23, 20, 10, 13, 6, 18, 35, 9, 24};
		tree.insertKeys(keys);
		tree.levelOrderPrint();
		
		tree.inorderPrint();
		System.out.println();
		
	}
	
	@Test
	public void testInsertDelete() {
		LinkedTree tree = new LinkedTree(); 
		int[] keys = {15, 23, 20, 10, 13, 6, 18, 35, 9, 24}; 
		tree.insertKeys(keys);
		tree.delete(6);
		tree.delete(15);
		tree.delete(20);
		tree.levelOrderPrint();
		
		System.out.println();
	}
	
	@Test
	public void testSumKeys() {
		LinkedTree tree = new LinkedTree();
		int[] keys = {8, 4, 10, 2};
		tree.insertKeys(keys);
		System.out.println(tree.sumKeys());
		assertEquals(24, tree.sumKeys());
		
		System.out.println();
	}
	*/
	@Test
	public void testSumAlongPath() {
        LinkedTree tree = new LinkedTree();
        int[] keys = {8, 4, 15, 2, 5, 30};
        tree.insertKeys(keys);
        System.out.println("test: " + tree.sumAlongPath(5));
        assertEquals(17, tree.sumAlongPath(5));
        System.out.println("test2: " + tree.sumAlongPath(12));
        assertEquals(23, tree.sumAlongPath(12));
    }
	

}
