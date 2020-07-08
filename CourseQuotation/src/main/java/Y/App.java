package Y;

import kong.unirest.Body;
import kong.unirest.Unirest;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParserConfigurationException, IOException, SAXException, IncorrectInputException, EmptyInputException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату: ");
        String date = scanner.nextLine();
        System.out.print("Введите идентификатор валют: ");
        String identifier = scanner.nextLine();
        System.out.print("Введите путь до файла: ");
        String file = scanner.nextLine();
        if (date.equals("") || identifier.equals("") || file.equals("")){
            throw new EmptyInputException("Введены не все аргументы");
        }

        String[] array = date.split("-");
        date.replaceAll("-","/");
        System.out.println( "Hello World!" );
        try {
            Unirest.get("http://www.cbr.ru/scripts/XML_daily.asp?date_req="+
                    array[2]+"/"+array[1]+"/"+array[0]).asFile("Course.xml").getBody();

        }catch (Exception e){
            throw new IncorrectInputException("Не верно введена дата(Пример 2019-02-15)");
        }

        File fXml = new File("Course.xml");
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        DocumentBuilder db=dbf.newDocumentBuilder();
        Document doc=db.parse(fXml);
        doc.getDocumentElement().normalize();
        NodeList nodeLst=doc.getElementsByTagName("Valute");
        for(int je=0;je<nodeLst.getLength();je++)
        {
            Node fstNode=nodeLst.item(je);
            if(fstNode.getNodeType()==Node.ELEMENT_NODE)
            {
                Element elj=(Element)fstNode;
                NodeList nljx=elj.getElementsByTagName("CharCode");
                Element eljx=(Element)nljx.item(0);
                NodeList nljxc=eljx.getChildNodes();
                NodeList nljy=elj.getElementsByTagName("Value");
                Element eljy=(Element)nljy.item(0);
                NodeList nljyc=eljy.getChildNodes();
                NodeList nljz=elj.getElementsByTagName("Name");
                Element eljz=(Element)nljz.item(0);
                NodeList nljzc=eljz.getChildNodes();
                if ((nljxc.item(0)).getNodeValue().equals(identifier)){
                    System.out.println("1 "+((Node)nljzc.item(0)).getNodeValue()+" = "
                            +((Node)nljyc.item(0)).getNodeValue()+" Российских рубля");
                    FileWriter writer = new FileWriter(file+".txt",true);
                    writer.write("1 "+((Node)nljzc.item(0)).getNodeValue()+" = "
                            +((Node)nljyc.item(0)).getNodeValue()+" Российских рубля\n");
                    writer.close();
                }


//                System.out.println(
//                        "CharCode,Value ["+((Node)nljxc.item(0)).getNodeValue()+", "+((Node)nljyc.item(0)).getNodeValue()+"]"
//                );
            }
        }
    }
}
