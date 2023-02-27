package UserInterface;
import Domain.CameraValidator;
import Repository.InMemoryCameraRepository;
import Service.CameraService;



public class Main {
    public static void main(String[] args) {

        InMemoryCameraRepository cameraRepository = new InMemoryCameraRepository();
        CameraValidator cameraValidator= new CameraValidator();
        CameraService cameraService = new CameraService(cameraRepository, cameraValidator);


        cameraService.addCamera("1", "camera1", 100, 2, "Regular");
        cameraService.addCamera("2", "camera2", 140, 5, "Regular");
        cameraService.addCamera("3", "camera3", 400, 2, "Business");
        cameraService.addCamera("4", "camera4", 420, 4, "Business");
        cameraService.addCamera("5", "camera5", 300, 2, "Executive");
        cameraService.addCamera("6", "camera6", 350, 6, "Executive");
        cameraService.addCamera("7", "camera7", 600, 1, "VIP");

        Console console = new Console(cameraService);

        console.runUi();
    }
}
