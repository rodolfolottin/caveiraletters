/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Baralho;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rodolfolottin
 */
public class JUnitTest {
	
    @Test
    public void isObject () throws Exception {
	Baralho testObject = new Baralho();
    }
    
    @Test
    public void retornaClasse() throws Exception {
        Baralho testObject = new Baralho();
       // assertEquals(testObject.getCartaAleatoria(), );
    }
}
