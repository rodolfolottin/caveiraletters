package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.List;

public class Rodada implements Jogada {
    
    private List<Lance> lances;

    public Rodada() {
    	lances = new ArrayList<Lance>();
    }
    
    public List<Lance> getLances() {
        return lances;
    }

    public void setLances(List<Lance> lances) {
        this.lances = lances;
    }

    public void addLance(Lance lance) {
        if (lances == null) {
            lances = new ArrayList<Lance>();
        }
        
        lances.add(lance);
    }
}
