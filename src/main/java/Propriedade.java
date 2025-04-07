public class Propriedade {
    private String id;
    private double area;
    private String proprietario;
    private String localizacao;


    public Propriedade(String id, double area, String proprietario, String localizacao) {
        this.id = id;
        this.area = area;
        this.proprietario = proprietario;
        this.localizacao = localizacao;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Propriedade{" +
                "id='" + id + '\'' +
                ", area=" + area +
                ", proprietario='" + proprietario + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
