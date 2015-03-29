/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import model.Carta;
import model.Jogador;
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
    
    private Jogador testObjectJogador;    
    
    @Before
    public void inicializar() {
        testObjectJogador = new Jogador(1, "Rodolfo");
    }
    
    @After
    public void terminou() {
        testObjectJogador = null;
    }
    
    @Test
    public void retornaNome() throws Exception {
        assertEquals("Rodolfo",testObjectJogador.getNome());
    }
    
    @Test
    public void retornaMesmaClasse() throws Exception {
        assertEquals(testObjectJogador, testObjectJogador);
    }
    
    
    
   
    
    
    
}
