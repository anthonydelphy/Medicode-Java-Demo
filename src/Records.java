import java.lang.*;
import java.util.*;

public class Records {
	private String prescriptions[];
	private String immunizations[];
	
	public Records(String _prescriptions[], String _immunizations[]) {
		prescriptions = _prescriptions;
		immunizations = _immunizations;
	}
	
	public String[] getPrescriptions() {
		return prescriptions;
	}
	
	public String[] getImmunizations() {
		return immunizations;
	}
	
	public void addPrescription(String prescription) {
		prescriptions = Arrays.copyOf(prescriptions, prescriptions.length + 1);
		prescriptions[prescriptions.length - 1] = prescription;
	}
	
	public void deletePrescription(String deletedPrescription) {
		int i = 0;
		while(!prescriptions[i].equals(deletedPrescription)){
			i++;
		}
		while(i < prescriptions.length)
		{
			prescriptions[i] = prescriptions[i+1];
		}
		
		prescriptions = Arrays.copyOf(prescriptions, prescriptions.length - 1);
		
	}
	
	public void addImmunization(String immunization) {
		immunizations = Arrays.copyOf(immunizations, immunizations.length + 1);
		immunizations[immunizations.length - 1] = immunization;
	}
}
