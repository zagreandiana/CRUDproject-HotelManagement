package UserInterface;
import Domain.Camera;
import Domain.CameraCuRaportPretPaturi;
import Service.CameraService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import Repository.InMemoryCameraRepository;

public class Console {
    private CameraService cameraService;
    Scanner scanner = new Scanner(System.in);

    public Console(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    public void runUi() {
        while (true) {
            this.showMenu();
            String opt = this.scanner.nextLine();
            switch (opt) {
                case "1":
                    this.handleAddCamera();
                    break;
                case "2":
                    this.handleShowAllCamera();
                    break;
                case "3":
                    this.handleShowPieseSortedByPretOverPaturi();
                    break;
                case "4":
                    this.handleUpdateCamere();
                    break;
                case "5":
                    this.handleDeleteCamere();
                    break;
                case "6":
                    this.handleShowsAverageNumberOfBedsForOneRoomType();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Optiune invalida!");
            }
        }
    }

    private void handleShowsAverageNumberOfBedsForOneRoomType(){
        Map<String, Float> Rezultat = InMemoryCameraRepository.MediePaturi();
        for (String tip : Rezultat.keySet()){
            System.out.println("Tipul camerei " + tip + "  - Media paturilor : " + Rezultat.get(tip));

        }
    }


    private void handleShowPieseSortedByPretOverPaturi() {
        for (CameraCuRaportPretPaturi cameraRaport : this.cameraService.getCamereSortedByPretOverPaturi()) {
            System.out.println(cameraRaport);
        }
    }
    private void handleUpdateCamere() {
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();

            System.out.println("Dati denumirea camerei (nenula):");
            String denumire = this.scanner.nextLine();

            System.out.println("Dati pretul camerei:");
            float pret = this.scanner.nextFloat();

            System.out.println("Dati numarul de paturi al camerei (> 0):");
            int numarPaturi = this.scanner.nextInt();

            this.scanner.nextLine();
            System.out.println("Dati tipul camerei (dintre Regular, Business, Executive, VIP):");
            String tip = this.scanner.nextLine();

            this.cameraService.updateCamera(id, denumire, pret, numarPaturi, tip);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }
    private void handleDeleteCamere(){
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();
            this.cameraService.deleteCamera(id);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }

    }
    private void handleShowAllCamera() {
        for (Camera camera : this.cameraService.getAll()) {
            System.out.println(camera);
        }
    }

    private void handleAddCamera() {
        try {
            System.out.println("Dati id-ul camerei (unic):");
            String id = this.scanner.nextLine();

            System.out.println("Dati denumirea camerei (nenula):");
            String denumire = this.scanner.nextLine();

            System.out.println("Dati pretul camerei:");
            float pret = this.scanner.nextFloat();

            System.out.println("Dati numarul de paturi al camerei (> 0):");
            int numarPaturi = this.scanner.nextInt();

            this.scanner.nextLine();
            System.out.println("Dati tipul camerei (dintre Regular, Business, Executive, VIP):");
            String tip = this.scanner.nextLine();

            this.cameraService.addCamera(id, denumire, pret, numarPaturi, tip);
        } catch (RuntimeException rex) {
            System.out.println(rex.getMessage());
        }
    }

    private void showMenu() {
        System.out.println("1. Adauga camera");
        System.out.println("2. Afisare camere");
        System.out.println("3. Raport cu camere ordonate crescator dupa raportul pret / numar de paturi");
        System.out.println("4. Update");
        System.out.println("5. Delete");
        System.out.println("6. Raport cu media numarului de paturi pentru fiecare tip de camera");
        System.out.println("7. Iesire");
    }
}
