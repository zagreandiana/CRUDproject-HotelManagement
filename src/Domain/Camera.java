package Domain;

public class Camera {
    private String id;
    private String denumire;
    private float pret;
    private int numarPaturi;
    private String tip;

    public Camera(String id, String denumire, float pret, int numarPaturi, String tip) {
        this.id = id;
        this.denumire = denumire;
        this.pret = pret;
        this.numarPaturi = numarPaturi;
        this.tip = tip;
    }

    public String getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public float getPret() {
        return pret;
    }

    public int getNumarPaturi() {
        return numarPaturi;
    }

    public String getTip() {
        return tip;

    }

    @Override
    public String toString() {
        return "Camera{" +
                "id='" + id + '\'' +
                ", denumire='" + denumire + '\'' +
                ", pret=" + pret +
                ", numarPaturi=" + numarPaturi +
                ", tip='" + tip + '\'' +
                '}';
    }
}
