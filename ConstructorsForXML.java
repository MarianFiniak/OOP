import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


public class ConstructorsForXML {




    /**
     * Запись настроек в XML файл
     */
    public void WriteParamXML(Simple<Demain> arrayList,String FILENAME) throws TransformerException, IOException {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //root elements
            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);

            //staff elements

            for (int i=0; i<arrayList.size();i++) {
                Element staff = doc.createElement("Staff");
                rootElement.appendChild(staff);
                //set attribute to staff element
                Attr attr = doc.createAttribute("id");
                attr.setValue(String.valueOf(i));
                staff.setAttributeNode(attr);

                //shorten way
                //staff.setAttribute("id", "1");

                //firstname elements
                Element firstname = doc.createElement("numberFlight");
                firstname.appendChild(doc.createTextNode(arrayList.get(i).getNumberFlight()));
                staff.appendChild(firstname);

                //lastname elements
                Element lastname = doc.createElement("Date");
                lastname.appendChild(doc.createTextNode(arrayList.get(i).getDate()));
                staff.appendChild(lastname);

                //nickname elements
                Element nickname = doc.createElement("numberOfSeats");
                nickname.appendChild(doc.createTextNode(arrayList.get(i).getNumberOfSeats()));
                staff.appendChild(nickname);

                Element count = doc.createElement("count");
                count.appendChild(doc.createTextNode(String.valueOf(arrayList.get(i).N)));
                staff.appendChild(count);
                for (int j = 0; j<arrayList.get(i).N;j++) {

                    //salary elements
                    Element station = doc.createElement("station");
                    staff.appendChild(station);



                    Element salary = doc.createElement("nameStation");
                    salary.appendChild(doc.createTextNode(arrayList.get(i).route.get(j).getNameStation()));
                    station.appendChild(salary);

                    Element salary1 = doc.createElement("Arrival");
                    salary1.appendChild(doc.createTextNode(arrayList.get(i).route.get(j).getDateArrival()));
                    station.appendChild(salary1);

                    Element salary2 = doc.createElement("Departure");
                    salary2.appendChild(doc.createTextNode(arrayList.get(i).route.get(j).getDateDeparture()));
                    station.appendChild(salary2);

                    Element salary3 = doc.createElement("FreeSeat");
                    salary3.appendChild(doc.createTextNode(arrayList.get(i).route.get(j).getFreeSeat()));
                    station.appendChild(salary3);
                }
            }
            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result =  new StreamResult(new File(FILENAME));
            transformer.transform(source, result);

            System.out.println("Done");

        }catch(ParserConfigurationException pce){
            pce.printStackTrace();
        }catch(TransformerException tfe){
            tfe.printStackTrace();
        }
    }
    public Simple<Demain> read(String FILENAME) throws ParserConfigurationException, IOException, SAXException {
        Simple<Demain> demains = new SimpleArray<>();
        Simple<String> lines = new SimpleArray<>();
        try {
            File fXmlFile = new File(FILENAME);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();


            NodeList nList = doc.getElementsByTagName("Staff");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

               if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;


                    lines.add(eElement.getElementsByTagName("numberFlight").item(0).getTextContent());
                    lines.add(eElement.getElementsByTagName("Date").item(0).getTextContent());
                    lines.add(eElement.getElementsByTagName("numberOfSeats").item(0).getTextContent());
                    lines.add(eElement.getElementsByTagName("count").item(0).getTextContent());
                    int N = Integer.parseInt(eElement.getElementsByTagName("count").item(0).getTextContent());
                   for (int i = 0; i<N;i++){
                       lines.add(eElement.getElementsByTagName("nameStation").item(i).getTextContent());
                       lines.add(eElement.getElementsByTagName("Arrival").item(i).getTextContent());
                       lines.add(eElement.getElementsByTagName("Departure").item(i).getTextContent());
                       lines.add(eElement.getElementsByTagName("FreeSeat").item(i).getTextContent());
                   }

                   Demain demain = new Demain(lines,N);
                   demains.add(demain);
                   lines.clear();
                  // System.out.println(demains.get(temp).getNumberFlight());

               }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demains;

    }
}