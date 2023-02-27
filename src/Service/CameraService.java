package Service;
import Domain.Camera;
import Domain.CameraCuRaportPretPaturi;
import Domain.CameraValidator;
import Repository.InMemoryCameraRepository;

import java.util.*;

public class CameraService {
    private InMemoryCameraRepository cameraRepository;
    private CameraValidator cameraValidator;

    public CameraService(InMemoryCameraRepository cameraRepository, CameraValidator cameraValidator) {
        this.cameraRepository = cameraRepository;
        this.cameraValidator = cameraValidator;
    }

    public void addCamera(String id, String denumire, float pret,
                          int numarPaturi, String tip) {
        Camera camera = new Camera(id, denumire, pret, numarPaturi, tip);
        this.cameraValidator.validate(camera);
        this.cameraRepository.create(camera);

    }

    public List<CameraCuRaportPretPaturi> getCamereSortedByPretOverPaturi() {
        List<CameraCuRaportPretPaturi> result = new ArrayList<>();
        for (Camera camera : this.getAll()) {
            result.add(new CameraCuRaportPretPaturi(camera, camera.getPret() / camera.getNumarPaturi()));
        }

        result.sort(new Comparator<CameraCuRaportPretPaturi>() {
            @Override
            public int compare(CameraCuRaportPretPaturi o1, CameraCuRaportPretPaturi o2) {
                return -Float.compare(o2.valoareRaportPretPaturi, o1.valoareRaportPretPaturi);
            }
        });

        return result;
    }

    public void deleteCamera(String id) {
        this.cameraRepository.delete(id);

    }

    public void updateCamera(String id, String denumire, float pret,
                             int numarPaturi, String tip) {
        Camera camera = new Camera(id, denumire, pret, numarPaturi, tip);
        this.cameraRepository.update(camera);

    }

    public List<Camera> getAll() {
        return cameraRepository.read();
    }




}
