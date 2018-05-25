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
        	  // DOM �ļ� ����
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            factory.setIgnoringElementContentWhitespace(true);// ���� ����
            
            DocumentBuilder builder = factory.newDocumentBuilder();            
            
            //XML ���� �Ľ�
            Document document = builder.parse("bml.xml"); //import org.w3c.dom.Document;
            
            
            
            //��Ʈ ������Ʈ ��ü ������
            Element rootElement = document.getDocumentElement(); //import org.w3c.dom.Element;
            
            
            
            Element bookElement = document.createElement("book");
            
            Element titleElement = document.createElement("title");
            Text titleText = document.createTextNode("���ΰ� ����");
            titleElement.appendChild(titleText);  // ����
            
            Element authorElement = document.createElement("author");
            Text authorText = document.createTextNode("�赵��");
            titleElement.appendChild(authorText);  // ����
            
            Element publisherElement = document.createElement("publisher");
            Text publisherText = document.createTextNode("�������ǻ�");
            publisherElement.appendChild(publisherText);  // ����
            
            Element priceElement = document.createElement("price");
            Text priceText = document.createTextNode("9000");
            priceElement.appendChild(priceText);  // ����
            
            bookElement.appendChild(titleElement);   // book�� ����
            bookElement.appendChild(authorElement);
            bookElement.appendChild(publisherElement);
            bookElement.appendChild(priceElement);
            
            
            rootElement.appendChild(bookElement);   // root�� ����
            
            
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
