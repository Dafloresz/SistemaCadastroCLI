package entities;

public class Endereco {
    private String numCasa;
    private String cidade;
    private String nomeRua;

    public Endereco(String numCasa, String cidade, String nomeRua) {
        this.numCasa = numCasa;
        this.cidade = cidade;
        this.nomeRua = nomeRua;
    }

    public String getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    @Override
    public String toString() {
        return getNomeRua() + ", " + getNumCasa() + ", " + getCidade();
    }
}
