/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Miguel Díaz, Eric Berlinches
 * @version 1.0
 *
 */
public class ReusablePoolTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		ReusablePool poolprueba1;
		  poolprueba1=ReusablePool.getInstance();
		  ReusablePool poolprueba2;
		  poolprueba2=ReusablePool.getInstance();
		  
		  assertEquals(true,poolprueba1==poolprueba2);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	@Test
	public void testAcquireReusable() {
		int i = 3;
		try {
			ReusablePool p = ReusablePool.getInstance();
			Reusable r;
			i = 3;
			while (i > 0) {
				r = p.acquireReusable();
				i --;
			}
			fail("Deberia haber lanzado excepcion por m�ximo de instancias utilizadas");
			
		} catch (NotFreeInstanceException e) {
			System.out.println("lanzada excepcion esperada, limite maximo de instancias");
			//e.printStackTrace();
			assertEquals(i, 1);
		}
		
		
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() {
		
		Reusable r1 = new Reusable();
		Reusable r2 = new Reusable();
		ReusablePool p = ReusablePool.getInstance();
		int releasados = 0;
		
		try {
			p.releaseReusable(r1);
			releasados ++;
			p.releaseReusable(r2);
			releasados ++;
			assertEquals(2, releasados);
			p.releaseReusable(r2);
			releasados ++;
			fail("se ha podido releasar una instancia ya releasada");
		} catch (DuplicatedInstanceException e) {
			System.out.println("RELEASEREUSABLE TEST: lanzada excepcion esperada, releasada instancia repetida");
			//e.printStackTrace();
			assertEquals(releasados, 2);
		}
	}
}