package bd.dbos;

public class Marca implements Cloneable {
    private int idMarca;
    private String nomeMarca;
    private int fundacao;
    private String proprietario;

    public void setIdMarca(int idMarca) throws Exception {
        if (idMarca <= 0) throw new Exception("idMarca invalido");

        this.idMarca = idMarca;
    }

    public void setNomeMarca(String nomeMarca) throws Exception {
        if (nomeMarca == null || nomeMarca.equals("")) throw new Exception("nomeMarca nao fornecido");

        this.nomeMarca = nomeMarca;
    }

    public void setFundacao(int fundacao) throws Exception {
        if (fundacao <= 0) throw new Exception("fundacao invalido");

        this.fundacao = fundacao;
    }

    public void setProprietario(String proprietario) throws Exception {
        if (proprietario == null || proprietario.equals("")) throw new Exception("proprietario nao fornecido");

        this.proprietario = proprietario;
    }

    public int getIdMarca() {
        return this.idMarca;
    }

    public String getNomeMarca() {
        return this.nomeMarca;
    }

    public int getFundacao() {
        return this.fundacao;
    }

    public String getProprietario() {
        return this.proprietario;
    }

    public Marca(int idMarca, String nomeMarca, int fundacao, String proprietario) throws Exception {
        this.setIdMarca(idMarca);
        this.setNomeMarca(nomeMarca);
        this.setFundacao(fundacao);
        this.setProprietario(proprietario);
    }

    public String toString() {
        String ret = "";

        ret += "idMarca: " + this.idMarca + "\n";
        ret += "idChassi: " + this.nomeMarca + "\n";
        ret += "nomeCarro.: " + this.fundacao + "\n";
        ret += "modelo.: " + this.proprietario;

        return ret;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Carro)) return false;

        Marca mar = (Marca) obj;

        if (this.idMarca != mar.idMarca) return false;
        if (this.nomeMarca.equals(mar.nomeMarca)) return false;
        if (this.fundacao != mar.fundacao) return false;
        if (this.proprietario.equals(mar.proprietario)) return false;

        return true;
    }

    public int hashCode() {
        int ret = 3;

        ret = 3 * ret + Integer.valueOf(this.idMarca).hashCode();
        ret = 3 * ret + this.nomeMarca.hashCode();
        ret = 3 * ret + Integer.valueOf(this.fundacao).hashCode();
        ret = 3 * ret + this.proprietario.hashCode();

        return ret;
    }

    public Marca(Marca marca) throws Exception {
        this.idMarca = marca.idMarca;
        this.nomeMarca = marca.nomeMarca;
        this.fundacao = marca.fundacao;
        this.proprietario = marca.proprietario;
    }

    public Object clone() {
        Marca ret = null;

        try {
            ret = new Marca(this);
        }
        catch (Exception erro) {
        }

        return ret;
    }
}
