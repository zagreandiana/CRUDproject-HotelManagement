package Domain;


    public class CameraCuRaportMediePaturiPentruUnTipCamera {
        public Camera camera;
        public float valoareMediePaturiCamera;


        public CameraCuRaportMediePaturiPentruUnTipCamera(Camera camera, float valoareMediePaturiCamera) {
            this.camera = camera;
            this.valoareMediePaturiCamera = valoareMediePaturiCamera;
        }

        @Override
        public String toString() {
            return "CameraCuRaportMediePaturiPentruUnTipCamera{" +
                    "camera=" + camera +
                    ", valoareMediePaturiCamera=" + valoareMediePaturiCamera +
                    '}';
        }
    }


