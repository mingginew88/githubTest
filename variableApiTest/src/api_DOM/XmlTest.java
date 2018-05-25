package api_DOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlTest {
	public static void main(String args[]) throws Exception{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder parser = dbf.newDocumentBuilder();
		Document xmldoc = parser.parse("student.xml");
		Element root = xmldoc.getDocumentElement();
		System.out.println(root);
		//xml 내용을 모두 출력
		System.out.println("root.getTextContent() : "+root.getTextContent());
		System.out.println("root.hasAttribute(김진영) : "+root.hasAttribute("김진영"));
		System.out.println("root.getUserData(학원) : " +root.getUserData("학원"));
		System.out.println("root.isSameNode(root)(같은노드인가) : "+root.isSameNode(root));
		System.out.println("root.TEXT_NODE(현재 노드의 갯수) : "+root.TEXT_NODE);
		System.out.println("root.hasChildNodes()(차일드노드가 있나) : "+root.hasChildNodes());

		//실제 객체 확인
		System.out.println();
		System.out.println(root.getClass().getName());
		System.out.println(dbf.getClass().getName());
		System.out.println(parser.getClass().getName());
		

		//다음은 어떻게 factory를 설정해 주는지 나타난 예제이다
		DocumentBuilder Builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		String location = "http://myserver/mycontent.xml";
		try{
			Builder = factory.newDocumentBuilder();
			Document document = Builder.parse(location);

		}catch(Exception e){
			//에러 핸들링
		}


	}
}
