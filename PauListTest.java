import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PauListTest
{
    @Test
    public void accessTests(){
        PauList<Integer> pauList = new PauList<Integer>();
        assertTrue(pauList.isEmpty());
        assertFalse(pauList.hasAccess());
        pauList.insert(1);
        assertFalse(pauList.isEmpty());
        assertFalse(pauList.hasAccess());
        pauList.toFirst();
        assertTrue(pauList.hasAccess());
        pauList.next();
        assertFalse(pauList.hasAccess());
    }
    
    @Test
    public void navigationTests(){
        PauList<Integer> pauList = new PauList<Integer>();
        pauList.append(1);
        pauList.append(2);
        pauList.append(3);
        pauList.append(4);
        pauList.append(5);
        
        assertEquals(null, pauList.getContent());
        pauList.next();
        assertEquals(null, pauList.getContent());
        pauList.toFirst();
        for(int i = 1; i <= 5; i++){
            assertEquals(i, pauList.getContent());
            pauList.next();
        }
        pauList.next();
        assertEquals(null, pauList.getContent());
    }
    
    @Test
    public void insertTests(){
        PauList<Integer> pauList = new PauList<Integer>();
        pauList.insert(null);
        assertTrue(pauList.isEmpty());
        
        pauList.insert(2);
        pauList.append(3);
        pauList.append(5);
        assertEquals(null, pauList.getContent());
        
        pauList.toFirst();
        assertEquals(2, pauList.getContent());
        pauList.next();
        assertEquals(3, pauList.getContent());
        pauList.next();
        assertEquals(5, pauList.getContent());
        pauList.next();
        assertEquals(null, pauList.getContent());
        
        pauList.toFirst();
        pauList.insert(1);
        assertEquals(2, pauList.getContent());
        pauList.toFirst();
        assertEquals(1, pauList.getContent());
        
        pauList.toLast();
        pauList.insert(4);
        assertEquals(5, pauList.getContent());
        pauList.toLast();
        assertEquals(5, pauList.getContent());
        
        pauList.toFirst();
        for(int i = 1; i <= 5; i++){
            assertEquals(i, pauList.getContent());
            pauList.next();
        }
        pauList.next();
        assertEquals(null, pauList.getContent());
    }
    
    @Test
    public void removeTests(){
        PauList<Integer> pauList = new PauList<Integer>();
        pauList.remove();
        assertTrue(pauList.isEmpty());
        assertFalse(pauList.hasAccess());
        
        pauList.append(1);
        pauList.append(2);
        pauList.append(3);
        pauList.append(4);
        pauList.append(5);
        
        pauList.remove();
        pauList.toFirst();
        for(int i = 1; i <= 4; i++){
            assertEquals(i, pauList.getContent());
            pauList.next();
        }
        
        pauList.toFirst();
        pauList.remove();
        assertEquals(2, pauList.getContent());
        pauList.toFirst();
        assertEquals(2, pauList.getContent());
        
        pauList.toLast();
        assertEquals(5, pauList.getContent());
        pauList.remove();
        assertEquals(4, pauList.getContent());
        
        pauList.toFirst();
        pauList.next();
        assertEquals(3, pauList.getContent());
        pauList.remove();
        assertEquals(4, pauList.getContent());
        pauList.remove();
        assertEquals(2, pauList.getContent());
        pauList.remove();
        assertEquals(null, pauList.getContent());
        assertFalse(pauList.hasAccess());
    }
    
    @Test
    public void concatTests(){
        PauList<Integer> pauList1 = new PauList<Integer>();
        pauList1.concat(null);
        
        PauList<Integer> pauList2 = new PauList<Integer>();
        pauList1.concat(pauList2);
        assertTrue(pauList1.isEmpty());
        
        pauList1.append(1);
        pauList1.append(2);
        pauList1.append(3);
        pauList2.append(4);
        pauList2.append(5);
        pauList2.append(6);
        
        pauList1.concat(pauList2);
        
        pauList1.toFirst();
        for(int i = 1; i <= 6; i++){
            assertEquals(i, pauList1.getContent());
            pauList1.next();
        }
        
        pauList2.toFirst();
        for(int i = 4; i <= 6; i++){
            assertEquals(i, pauList2.getContent());
            pauList2.next();
        }
    }

}


