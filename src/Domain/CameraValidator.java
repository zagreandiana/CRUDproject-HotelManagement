package Domain;

public class CameraValidator {
    public void validate(Camera camera){
        String errors = "";
        if(camera.getId().isEmpty()){
            errors += "Id-ul camerei nu poate fi nul!\n";
        }
        if(camera.getDenumire().isEmpty()){
            errors += "Denumirea camerei nu poate fi goala!\n";
        }
        if(camera.getPret() < 0){
            errors += "Pretul camerei nu poate fi reprezentat de un numar nergativ!\n";
        }
        if(camera.getNumarPaturi() < 0){
            errors += "Numarul paturilor trebuie sa fie >=0!\n";
        }
        if(!camera.getTip().equals("Regular") && !camera.getTip().equals("Executive")
                && !camera.getTip().equals("Business") && !camera.getTip().equals("VIP")){
            errors += "Tipul camrei trebuie sa fie unul dintre urmatoarele: Regular, Executive, Business, VIP!\n";
        }

        if(!errors.isEmpty()){
            throw new RuntimeException(errors);
        }

    }
}
