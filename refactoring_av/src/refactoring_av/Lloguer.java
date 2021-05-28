package refactoring_av;

import java.util.Date;
import java.util.ArrayList;

public class Lloguer {
	private Date data;
	private int dies;
	private Vehicle vehicle;
	
	public Lloguer(Date data, int dies, Vehicle vehicle) {
		this.data = data;
		this.dies = dies;
		this.vehicle = vehicle;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getDies() {
		return dies;
	}

	public void setDies(int dies) {
		this.dies = dies;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicles(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public double quantitat() {
		double retorna_quantitat = 0;
		switch (getVehicle().getCategoria()) {
        case Vehicle.BASIC:
            retorna_quantitat += 3;
            if (getDies() > 3) {
                retorna_quantitat += (getDies() - 3) * 1.5;
            }
            break;
        case Vehicle.GENERAL:
            retorna_quantitat += 4;
            if (getDies() > 2) {
                retorna_quantitat += (getDies() - 2) * 2.5;
            }
            break;
        case Vehicle.LUXE:
            retorna_quantitat += getDies() * 6;
            break;
    }
		return retorna_quantitat;
	}
}
