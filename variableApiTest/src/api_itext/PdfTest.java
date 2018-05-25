package api_itext;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.PageSize;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.CMYKColor;
//import com.itextpdf.text.pdf.PdfObject;
//import com.itextpdf.text.pdf.PdfReader;
//import com.itextpdf.text.pdf.PdfWriter;

//http://cafe.naver.com/aphone/15712
//http://cafe.naver.com/prvd/4755
//http://cafe.naver.com/youllisys/34
//https://www.ibm.com/developerworks/java/library/os-javapdf/index.html
public class PdfTest {
	public static void main(String[] args) {
//		Document doc = new Document();
//		Document doc2 = new Document(PageSize.A4);
//		Document doc3 = new Document(PageSize.A4, 30F, 30F, 30F, 30F);	
//		
//		try {
//			FileInputStream is;
//			is = new FileInputStream("C:\\Users\\PC17\\Desktop\\12.pdf");
//			PdfReader pdfReader = new PdfReader(is);
//			int page = pdfReader.getNumberOfPages();
//			System.out.println("������ �� : " + page);
//			
//			pdfReader.selectPages("1-1");//������ 1-1������ ���� ���������� ��.
//			System.out.println();
//			
//			pdfReader.getPageRotation(1);//
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//		try {
//			FileOutputStream os;
//			os = new FileOutputStream("C:\\Users\\PC17\\Desktop\\12.pdf");
//			PdfWriter prfWriter = PdfWriter.getInstance(doc, os);
//			doc.open();
//			
//			doc.add(new Paragraph("First page of the document"));		
//			doc.add(new Paragraph("success!", FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));
//			Paragraph p = new Paragraph();
//			p.add("It's too difficult to learn PDFFileReader.");
//			p.setAlignment(Element.ALIGN_CENTER); 	//�߾�
//			doc.add(p);
//			
//			Font f = new Font();
//			f.setStyle(Font.BOLD);
//			f.setSize(20);
//			
//			doc.add(new Paragraph("Good Night!", f));
//			
//			System.out.println("�Ϸ�");
//			doc.close();
//		} catch (FileNotFoundException | DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
}


/*
Listing 1. Instantiation of document object
Listing 2. Creation of PdfWriter object
Listing 3. Creation of paragraph object
Listing 4. Creation of chapter object
Listing 5. Creation of section object
Listing 6. Creation of table object
Listing 7. Creation of list object
Listing 8. Adding Image to the main Document
Listing 9. Adding Anchor to the main document
Listing 10. Addition of a chapter to the main document
 */


/*
ITEXT�� �̿��Ͽ� PDF���� �����

1. com.lowalge.text.DocumentŬ���� �ν��Ͻ��� �����Ѵ�.
2. Writer�� Document������ ������ �ξ��ش�.
   Writer�� �̿��Ͽ� ������ �ϵ��ũ �� �� �������� �ִ�.
   PDFWriter.getInstance(document, newFileOUtputStream   ("Helloworld.PDF"));
3. ������ �����Ѵ�.
   document.open();
4. ������ ������ ÷���Ѵ�.
   document.add(new Paragraph("Hello World");
5. ������ �ݴ´�.
   document.close();
 */










