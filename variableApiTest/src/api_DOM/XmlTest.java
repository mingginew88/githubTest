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
		//xml ������ ��� ���
		System.out.println("root.getTextContent() : "+root.getTextContent());
		System.out.println("root.hasAttribute(������) : "+root.hasAttribute("������"));
		System.out.println("root.getUserData(�п�) : " +root.getUserData("�п�"));
		System.out.println("root.isSameNode(root)(��������ΰ�) : "+root.isSameNode(root));
		System.out.println("root.TEXT_NODE(���� ����� ����) : "+root.TEXT_NODE);
		System.out.println("root.hasChildNodes()(���ϵ��尡 �ֳ�) : "+root.hasChildNodes());

		//���� ��ü Ȯ��
		System.out.println();
		System.out.println(root.getClass().getName());
		System.out.println(dbf.getClass().getName());
		System.out.println(parser.getClass().getName());
		

		//������ ��� factory�� ������ �ִ��� ��Ÿ�� �����̴�
		DocumentBuilder Builder;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		String location = "http://myserver/mycontent.xml";
		try{
			Builder = factory.newDocumentBuilder();
			Document document = Builder.parse(location);

		}catch(Exception e){
			//���� �ڵ鸵
		}


	}
}
