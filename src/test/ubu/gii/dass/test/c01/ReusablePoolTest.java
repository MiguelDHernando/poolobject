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
 * @author alumno
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
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */
	

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
