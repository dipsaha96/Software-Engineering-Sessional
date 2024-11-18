public class WebServerFactory {
    public static WebServer createFrameWork(String frameWork) {
        if (frameWork.equals("Django")) {
            return new Django();
        } else if (frameWork.equals("NodeJS")) {
            return new NodeJS();
        } else if (frameWork.equals("Ruby")) {
            return new Ruby();
        } else {
            return null;
        }
    }
}
