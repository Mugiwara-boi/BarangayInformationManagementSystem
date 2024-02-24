package systemGUI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class BIMS_brgyClearance {

	public BIMS_brgyClearance(String name, String address, String date) throws MalformedURLException, IOException {
		
		try {
		String file_name="C:\\Users\\Vinn\\Desktop\\BarangayClearance.pdf";
		Document document=new Document();

		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		
		document.open();
		
		Font i=new Font(FontFamily.TIMES_ROMAN,12,Font.BOLD);
		Font f=new Font(FontFamily.TIMES_ROMAN);		
		Paragraph para=new Paragraph("  Republic of the Philippines  ",f);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		
		Paragraph para1=new Paragraph("City of Mandaluyong",f);
		para1.setAlignment(Element.ALIGN_CENTER);
		document.add(para1);

		Paragraph para2=new Paragraph("Barangay Hulo",f);
		para2.setAlignment(Element.ALIGN_CENTER);
		document.add(para2);
		
		Paragraph para3=new Paragraph("Office Of the Barangay Captain",f);
		para3.setAlignment(Element.ALIGN_CENTER);
		document.add(para3);
		
		document.add(new Paragraph ("  "));
		
		Font g = new Font(FontFamily.TIMES_ROMAN,30,Font.BOLD);
		Paragraph para4=new Paragraph("BARANGAY CLEARANCE",g);
		para4.setAlignment(Element.ALIGN_CENTER);
		document.add(para4);

		
		document.add(new Paragraph ("  "));
		
		Paragraph para6=new Paragraph("To whom it may concern, ",f);
		para6.setAlignment(Element.ALIGN_LEFT);
		document.add(para6);
		
		document.add(new Paragraph ("  "));
		
		//Paragraph para7=new Paragraph("This is to certify that Mr./Ms.____________________, of legal age, a resident of Barangay Hulo, Mandaluyong City, rightful owner of _________ is cleared to construct a Residential building located at Brgy. Hulo, Mandaluyong City, is made of Light Materials.",f);
		//para7.setAlignment(Element.ALIGN_LEFT);
		//document.add(para7);
		
		
		Chunk parag1 = new Chunk("This is to certify that Mr./Ms. ", f);
        Chunk parag2 = new Chunk(name, i); 
        Chunk parag3 = new Chunk(" of legal age, a resident of Barangay Hulo, Mandaluyong City, rightful owner of ",f);
        Chunk parag4 = new Chunk(address, i);
        Chunk parag5 = new Chunk(" is cleared to construct a Residential building located at Brgy. Hulo, Mandaluyong City, is made of Light Materials.", f);
        Paragraph comb = new Paragraph();
        comb.add(new Chunk(parag1));
        comb.add(new Chunk(parag2));
        comb.add(new Chunk(parag3));
        comb.add(new Chunk(parag4));
        comb.add(new Chunk(parag5));
        comb.setAlignment(Element.ALIGN_LEFT);
        document.add(comb);
        		
		document.add(new Paragraph ("  "));
		
		Paragraph para8=new Paragraph("I further certify that the holder/bearer was informed of his rights, including the duties and responsibilities accorded by RA 11261 through the Oath of Undertaking he has signed and executed in the presence of our Barangay Official",f);
		para8.setAlignment(Element.ALIGN_LEFT);
		document.add(para8);
		
		document.add(new Paragraph ("  "));
		
		
		Chunk parag6 = new Chunk("Done this ", f);
        Chunk parag7 = new Chunk(date, i); 
        Chunk parag8 = new Chunk(" at Barangay Hulo, Mandaluyong City.",f);
        Paragraph comb1 = new Paragraph();
        comb1.add(new Chunk(parag6));
        comb1.add(new Chunk(parag7));
        comb1.add(new Chunk(parag8));
        comb.setAlignment(Element.ALIGN_LEFT);
        document.add(comb1);
        
			
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		
	
		Paragraph para10=new Paragraph("BERNARDO C. MAGLAQUE",i);
		para10.setAlignment(Element.ALIGN_RIGHT);
		document.add(para10);
		
		
		Paragraph para11=new Paragraph("Punong Barangay            ",f);
		para11.setAlignment(Element.ALIGN_RIGHT);
		document.add(para11); 
		
		
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		document.add(new Paragraph ("  "));
		
		Image logo = Image.getInstance("C:\\Users\\Vinn\\Downloads\\mandaluyong-city.png");
		logo.setAbsolutePosition(400,700);
		logo.scaleAbsolute(100, 100);
		document.add(logo);
		
		Image logo2 = Image.getInstance("C:\\Users\\Vinn\\Downloads\\HULO.png");
		logo2.setAbsolutePosition(100,700);
		logo2.scaleAbsolute(100, 100);
		document.add(logo2);
		
		
		document.close();
		
		System.out.print("finished");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

	}

}

