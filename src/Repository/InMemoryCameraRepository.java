package Repository;
import Domain.Camera;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryCameraRepository {
    public static Map<String, Camera> storage = new HashMap<>();


    public void create(Camera camera) {
        if (storage.containsKey(camera.getId())) {
            throw new RuntimeException("Exista deja o camera cu id-ul " + camera.getId());
        }

        this.storage.put(camera.getId(), camera);
    }


    public List<Camera> read() {
        return new ArrayList<>(storage.values());
    }

    public void update(Camera camera) {
        if (!storage.containsKey(camera.getId())) {
            throw new RuntimeException("Nu exista nicio camera cu id-ul " + camera.getId());
        }

        this.storage.put(camera.getId(), camera);
    }

    public void delete(String idCamera) {
        if (!storage.containsKey(idCamera)) {
            throw new RuntimeException("Nu exista nicio camera cu id-ul " + idCamera);
        }

        this.storage.remove(idCamera);
    }


    public static Map<String, Float> MediePaturi() {
        Map<String, Float> Paturi = new HashMap<String, Float>();
        Paturi.put("Regular", (float)0);
        Paturi.put("Executive", (float)0);
        Paturi.put("Business", (float)0);
        Paturi.put("VIP", (float)0);
        for( String tipCameraCurenta : Paturi.keySet()){
            float nrCamere = 0;
            float nrPaturi = 0;
            float medie = 0;
            for( Camera cameraCurenta : storage.values()){
                if(tipCameraCurenta == cameraCurenta.getTip()){
                    nrCamere++;
                    nrPaturi=cameraCurenta.getNumarPaturi()+nrPaturi;
                }
                if(nrCamere>=1){
                    medie = nrPaturi/nrCamere;
                    Paturi.put(tipCameraCurenta, medie);

                }
            }

        }
        return Paturi;
    }

}
