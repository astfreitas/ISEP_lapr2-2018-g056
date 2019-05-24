/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.test;

import lapr.project.model.Categoria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomasmagalhaes
 */
public class CategoriaTest {
    
    public CategoriaTest() {
    }
    
   

    /**
     * Test of hasId method, of class Categoria.
     */
    @Test
    public void testHasId() {
        System.out.println("hasId");
        String strId = "1";
        Categoria instance = new Categoria(" ", " ");
        boolean expResult = false;
        boolean result = instance.hasId(strId);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodigo method, of class Categoria.
     */
    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        Categoria instance = new Categoria(" ", " ");
        String expResult = " ";
        String result = instance.getCodigo();
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Categoria.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Categoria instance = new Categoria(" ", " ");
        int expResult = 193;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Categoria.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new Categoria("2", " ");
        Categoria instance = new Categoria(" ", "1");
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Categoria.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Categoria instance = new Categoria("1", "2");
        String expResult = "1 - 2 ";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
