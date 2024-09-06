//java로 html 만들기 ( 시스템 속성값 )
//이름: 최정인

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class makeHtml {
    public static void main(String[] args)throws IOException {

            File file = new File("C:\\Users\\최정인\\Desktop\\index.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            // 자바에서 .write로 html 코드 작성할 수 있음!!!
      
            writer.write("<head>");
            writer.write("<meta charset=utf-8/>");
            writer.write("<style>");
            writer.write("table{border-collapse: collapse; width: 100%;}");
            writer.write("th, td { border : solid 1px #000;}");
            writer.write("</style>");
            writer.write("</head>");
            writer.write("<body>");
            writer.write("<h2>자바 환경정보</h2>");
            writer.write("<table>");
            writer.write("<th>키</th>");
            writer.write("<th/>");

        for (Object k : System.getProperties().keySet()) {
            String key = k.toString();
            String value = System.getProperty(key);


            try {
                writer.write("<tr><th>" + key + "</th>");
                writer.write("<td>" + value + "</td></tr>");

            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        writer.write("</table>");
        writer.write("</body>");
        writer.close();
    }
}
