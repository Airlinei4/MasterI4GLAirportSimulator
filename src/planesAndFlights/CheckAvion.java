package planesAndFlights;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runners.JUnit4;

public class CheckAvion {

	@Test
	public void testEnumAvion() {
		//Controle du nombre d'avions dans EnumAvion
		EnumAvion[] listAvion = EnumAvion.values();
		ArrayList<IAvion> listIavion = new ArrayList<IAvion>();
		for(IAvion avion : listAvion){
			listIavion.add(avion);
		}
		assert(listIavion.size() == 5);
	}
	
	@Test (expected = Exception.class)
	public void testValeursCorrectes(){
		Avion avion = new Avion("monAvion");
		ArrayList<Object> nouvellesValeurs = new ArrayList<Object>();
		nouvellesValeurs.add("monAvion");
		nouvellesValeurs.add(-3);
		nouvellesValeurs.add(8);
		nouvellesValeurs.add(9);
		nouvellesValeurs.add(89);
		nouvellesValeurs.add(36);
		
		try {
			avion.setAttributesList(nouvellesValeurs);
			fail();
		} catch (Exception e) {
			assert(e.getMessage() == "La capacite d'un avion ne peut etre inferieure a "+ IAvion.capaciteMinimale+" passagers");
		}
	}
	
	

}
