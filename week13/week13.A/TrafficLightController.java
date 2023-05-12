import java.io.IOException;

public class TrafficLightController {
    public static void main(String[] args) {
        System.out.println("Press Enter to stop");
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.start();
    }
    private static class TrafficLight extends Thread implements Runnable {
        @Override
        public void run() {
            try {
                int i = 0;
                while (System.in.available() == 0) {
                    switch(i) {
                        case 0:
                            System.out.println("red");
                            i++;
                            Thread.sleep(5000);
                            break;
                        case 1:
                            System.out.println("yellow");
                            i++;
                            Thread.sleep(2000);
                            break;
                        case 2:
                            System.out.println("green");
                            i = 0;
                            Thread.sleep(10000);
                            break;
                    }
                }
                throw new InterruptedException();
            } catch (InterruptedException e) {
                System.out.println("Thank you! Have a good day!");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
