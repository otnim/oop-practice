public class Browser {
    public void navigate(String address){
        String ip = getIpAddress(address);
        String http = getHttpContent();
    }

    private String getHttpContent() {
        String s = "<http> http content </http>";
        return s;
    }

    private String getIpAddress(String address) {
        return "127.12.0.5";
    }
}
