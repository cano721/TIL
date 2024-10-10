package java_version_feature;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

/**
 * Java 18 Features
 *
 * 1. JEP 408: Simple Web Server
 * 간단한 웹 서버를 구축할 수 있는 기능 제공
 *
 * 2. JEP 400: UTF-8 Property Files
 * UTF-8 인코딩을 지원하는 Property 파일을 사용할 수 있게 됨
 *
 * 3. JEP 413: Code Snippets in Java API Documentation
 * Java API 문서에 코드 스니펫을 포함할 수 있게 됨
 */
public class Java18 {
    public static void main(String[] args) throws IOException {
        testSimpleWebServer();
        testCodeSnippet();
    }

    /**
     * This method shows an example of the `@snippet` tag.
     * {@snippet :
     *       System.out.println("Hello, Java 18!");
     * }
     */
    private static void testCodeSnippet() {
        System.out.println("Hello, Java 18!");
    }

    /**
     * Simple Web Server
     * 간단한 웹 서버 테스트
     *
     * 간략한 개발 및 테스트 환경에서 활용할만해보임
     * @throws IOException
     */
    private static void testSimpleWebServer() throws IOException {
        // 포트 8080에서 HTTP 서버 실행
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // '/' 경로로 들어오는 요청에 대해 간단한 응답 제공
        server.createContext("/", exchange -> {
            String response = "Hello, Simple Web Server!";
            exchange.sendResponseHeaders(200, response.getBytes().length);
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });

        // 서버 시작
        server.start();
        System.out.println("Server started on port 8080");
    }


}
