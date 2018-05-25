package api_DOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class XmlTest2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
        	  // DOM 파서 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            factory.setIgnoringElementContentWhitespace(true);// 공백 무시
            
            DocumentBuilder builder = factory.newDocumentBuilder();            
            
            //XML 문서 파싱
            Document document = builder.parse("bml.xml"); //import org.w3c.dom.Document;
            
            
            
            //루트 엘리먼트 객체 얻어오기
            Element rootElement = document.getDocumentElement(); //import org.w3c.dom.Element;
            
            
            
            Element bookElement = document.createElement("book");
            
            Element titleElement = document.createElement("title");
            Text titleText = document.createTextNode("시인과 도둑");
            titleElement.appendChild(titleText);  // 연결
            
            Element authorElement = document.createElement("author");
            Text authorText = document.createTextNode("김도둑");
            titleElement.appendChild(authorText);  // 연결
            
            Element publisherElement = document.createElement("publisher");
            Text publisherText = document.createTextNode("시인출판사");
            publisherElement.appendChild(publisherText);  // 연결
            
            Element priceElement = document.createElement("price");
            Text priceText = document.createTextNode("9000");
            priceElement.appendChild(priceText);  // 연결
            
            bookElement.appendChild(titleElement);   // book에 연결
            bookElement.appendChild(authorElement);
            bookElement.appendChild(publisherElement);
            bookElement.appendChild(priceElement);
            
            
            rootElement.appendChild(bookElement);   // root에 연결
            
            
            System.out.println("-------------Before---------------");
            NodeList titleElements = rootElement.getElementsByTagName("title");
            for(int i=0;i<titleElements.getLength(); i++){
                Element titleEle = (Element)titleElements.item(i);
                Text titleTex = (Text)titleEle.getFirstChild();
                System.out.println(titleTex.getData());
            }
            
            rootElement.removeChild(bookElement);
            
            System.out.println("-------------After---------------");
            
            for(int i=0;i<titleElements.getLength(); i++){
                Element titleEle = (Element)titleElements.item(i);
                Text titleTex = (Text)titleEle.getFirstChild();
                System.out.println(titleTex.getData());
            }
        }catch(Exception e){
            e.printStackTrace();
        }


	}
}
