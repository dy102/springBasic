package hello.core.lifecycle;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시i작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    //실제 콜 연결이 된 상태에서 콜을 부름
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출 -> 안전하게 서비스 연결이 끊어짐.
    public void disconnect() {
        System.out.println("close: " + url);
    }

    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");//메시지를 보냄
    }

    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
