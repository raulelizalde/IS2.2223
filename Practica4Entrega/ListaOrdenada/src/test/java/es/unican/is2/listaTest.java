package es.unican.is2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.ListaOrdenada.IListaOrdenada;
import es.unican.is2.ListaOrdenada.ListaOrdenada;

class listaTest {

	private IListaOrdenada<Integer> lista;

	@BeforeEach
	void setUp() throws Exception {
		lista = new ListaOrdenada<Integer>();
	}
	
	@Test
	void testValidoSize() {
		lista.add(100);
		lista.add(1);
		lista.add(10);
		//comprobamos que hay 3 elementos
		assertEquals(3, lista.size());
	}
	
	@Test
	void testValidoAdd() {
		lista.add(100);
		lista.add(1);
		lista.add(10);
		//comprobamos que hay 3 elementos
		assertEquals(1, lista.get(0));
		assertEquals(10, lista.get(1));
		assertEquals(100, lista.get(2));
	}
	
	@Test 
	void testValidoRemove() {
		lista.add(100);
		lista.add(1);
		lista.add(10);
		lista.remove(1);
		assertEquals(2, lista.size());
		assertEquals(100, lista.get(1));
		
	}
	
	@Test 
	void testValidoClear() {
		lista.add(100);
		lista.add(1);
		lista.add(10);
		lista.clear();
		assertEquals(0, lista.size());
		
	}
	

}
