package bd.dbos;

public class Carro implements Cloneable {
    private int idMarca;
    private int idCarro;
    private String modelo;

    public void setIdMarca(int idMarca) throws Exception {
        if (idMarca <= 0) throw new Exception("idMarca invalido");

        this.idMarca = idMarca;
    }

    public void setIdCarro(int idCarro) throws Exception {
        if (idCarro <= 0) throw new Exception("idCarro invalido");

        this.idCarro = idCarro;
    }

    public void setModelo(String modelo) throws Exception {
        if (modelo == null || modelo.equals("")) throw new Exception("modelo nao fornecido");

        this.modelo = modelo;
    }

    public int getIdMarca() {
        return this.idMarca;
    }

    public int getIdCarro() {
        return this.idCarro;
    }

    public String getModelo() {
        return this.modelo;
    }

    public Carro(int idMarca, int idCarro, String modelo) throws Exception {
        this.setIdMarca(idMarca);
        this.setIdCarro(idCarro);
        this.setModelo(modelo);
    }

    public String toString() {
        String ret = "";

        ret += "idMarca: " + this.idMarca + "\n";
        ret += "idCarro: " + this.idCarro + "\n";
        ret += "modelo.: " + this.modelo;

        return ret;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Carro)) return false;

        Carro car = (Carro) obj;

        if (this.idMarca != car.idMarca) return false;
        if (this.idCarro != car.idCarro) return false;
        if (this.modelo.equals(car.modelo)) return false;

        return true;
    }

    public int hashCode() {
        int ret = 3;

        ret = 3 * ret + Integer.valueOf(this.idMarca).hashCode();
        ret = 3 * ret + Integer.valueOf(this.idCarro).hashCode();
        ret = 3 * ret + this.modelo.hashCode();

        return ret;
    }

    public Carro(Carro carro) throws Exception {
        this.idMarca = carro.idMarca;
        this.idCarro = carro.idCarro;
        this.modelo = carro.modelo;
    }

    public Object clone() {
        Carro ret = null;

        try {
            ret = new Carro(this);
        }
        catch (Exception erro) {
        }

        return ret;
    }
}
