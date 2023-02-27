package Domain;

public class CameraCuRaportPretPaturi {
    public Camera camera;
    public float valoareRaportPretPaturi;

    public CameraCuRaportPretPaturi(Camera camera, float valoareRaportPretPaturi) {
        this.camera = camera;
        this.valoareRaportPretPaturi = valoareRaportPretPaturi;
    }

    @Override
    public String toString() {
        return "CameraCuRaportPretPaturi{" +
                "camera=" + camera +
                ", valoareRaportPretPaturi=" + valoareRaportPretPaturi +
                '}';
    }
}
