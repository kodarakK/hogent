
package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import persistentie.VoorwerpMapper;

public class VoorwerpRepository
{
	private final VoorwerpMapper vm;
	//private final Voorwerp[] voorwerpen;
	
	private List<Voorwerp> voorwerpen;
	
	
	public VoorwerpRepository() {
		vm = new VoorwerpMapper();
		//voorwerpen = vm.geefVoorwerpen();
		voorwerpen = new ArrayList<>(Arrays.asList(vm.geefVoorwerpen()));
	}
	
//	public Voorwerp[] getVoorwerpen() {
//		return voorwerpen;
//	}
	
	public List<Voorwerp> getVoorwerpen() {
		return voorwerpen;
	}
	
	public void voegVoorwerpToe(Voorwerp v) {
		voorwerpen.add(v);
	}
	
	
	
	
}
