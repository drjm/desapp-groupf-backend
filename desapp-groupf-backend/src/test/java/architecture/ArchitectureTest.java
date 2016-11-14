package architecture;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;

import service.GenericService;

public class ArchitectureTest {

	private String packageModel = "model";
	private String packageAspects = "aspects";
	private String packagePersistence = "persistence";
	private String packageService = "service";
	private String packageWebService = "model";

	/*
	 * Verificamos que en los paquetes que no son "service" no hay clases que
	 * extiendan de "GenericService"
	 * 
	 */
	@Test
	public void testPackegeService() throws InstantiationException, IllegalAccessException {

		Integer cantidadClasesIncorrectas = 0;

		ArrayList<String> namesPackages = new ArrayList<String>();

		namesPackages.add(this.packageAspects);
		namesPackages.add(this.packageModel);
		namesPackages.add(this.packagePersistence);
		// namesPackages.add(this.packageService);
		namesPackages.add(this.packageWebService);

		for (String pack : namesPackages) {
			Object[] clases = this.getAllClassForPackage(pack, GenericService.class);
			System.out.println("package: " + pack + " - cantidad de clases: " + clases.length);
			cantidadClasesIncorrectas += clases.length;
		}
		assertTrue(0 == cantidadClasesIncorrectas);
	}

	public Object[] getAllClassForPackage(String namePackage, Class clase) {

		Reflections reflections = new Reflections(namePackage);
		Object[] clases = ((HashSet) reflections.getSubTypesOf(clase)).toArray();
		return clases;

	}

}