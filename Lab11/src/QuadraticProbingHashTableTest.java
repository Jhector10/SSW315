import static org.junit.Assert.*;

import org.junit.Test;

public class QuadraticProbingHashTableTest {

	private final QuadraticProbingHashTable table;
    private final QuadraticProbingHashTable stringTable;
    private final int[] nums = new int[] { 7, 22, 44, 43, 27, 89, 30, 64, 85 };
    private final String[] str = { "A", "W", "X", "Y", "CM", "CK", "BD", "H", "MOB", "BD" };
    
    public QuadraticProbingHashTableTest() {
        table = new QuadraticProbingHashTable(21);
        stringTable = new QuadraticProbingHashTable(23);
    }
    
    @Test
    public void testInsert() {
    	for(int i = 0; i < nums.length; i++) {
    		table.insert(new MyInteger(nums[i]));;
    	}
    	
    	HashEntry[] array = table.getTable();
    	
    	assertEquals(7, Integer.parseInt(array[7].element.toString()));
    	assertEquals(22, Integer.parseInt(array[1].element.toString()));
    	assertEquals(44, Integer.parseInt(array[2].element.toString()));
    	assertEquals(43, Integer.parseInt(array[5].element.toString()));
    	assertEquals(27, Integer.parseInt(array[6].element.toString()));
    	assertEquals(89, Integer.parseInt(array[9].element.toString()));
    	assertEquals(30, Integer.parseInt(array[10].element.toString()));
    	assertEquals(64, Integer.parseInt(array[17].element.toString()));
    	assertEquals(85, Integer.parseInt(array[16].element.toString())); 
    }
    
    @Test
    public void testString() {
    	for (String s : str)
            stringTable.insert(new MyInteger(stringTable.hash(s, 23)));
    	
    	HashEntry[] table = stringTable.getTable();

        for (String s : str) {
            int hash = stringTable.hash(s, 23);
            assertEquals(new MyInteger(hash), table[hash].element);
        }
    }
    
    

}
