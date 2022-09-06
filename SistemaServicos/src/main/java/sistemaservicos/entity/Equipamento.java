package sistemaservicos.entity;

import gate.annotation.Name;
import gate.type.ID;

@Name("Equipamento")
public class Equipamento {
    private ID id;
    private String fabricante;
    private String modelo;
    private String serial;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    
}

