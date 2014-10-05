package edu.hm.jaumann.Config;

import edu.hm.jaumann.data.PriecingBundle;
import edu.hm.jaumann.data.basic.base.VulnerableObjektPrototype;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;


public class ObjektXMLmaker {
    public ObjektXMLmaker() {
    }
//    public void writePrototype(final VulnerableObjektPrototype data)
//    {
//        try
//        {
//            final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
//            //root elements
//            Document doc = docBuilder.newDocument();
//
//            Element rootElement = doc.createElement("Gameobjekt");
//            doc.appendChild(rootElement);
//            createConfiguration(data, doc, rootElement);
//
//
//            //writePrototype the content into xml file
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result =  new StreamResult(new File("C:\\Users\\Michael\\Desktop\\testing.xml"));
//            transformer.transform(source, result);
//
//            System.out.println("Done");
//
//        }catch(ParserConfigurationException pce){
//            pce.printStackTrace();
//        }catch(TransformerException tfe){
//            tfe.printStackTrace();
//        }
//}
//    private void createPriecingBundle(final PriecingBundle bundle, final Document doc, final Element rootElement) {
//        //name elements
//        final Element feed = doc.createElement("Feed");
//        feed.appendChild(doc.createTextNode(String.valueOf(bundle.getFeed())));
//        rootElement.appendChild(feed);
//
//        final Element gold = doc.createElement("Gold");
//        gold.appendChild(doc.createTextNode(String.valueOf(bundle.getGold())));
//        rootElement.appendChild(gold);
//
//        final Element mana = doc.createElement("Mana");
//        mana.appendChild(doc.createTextNode(String.valueOf(bundle.getMana())));
//        rootElement.appendChild(mana);
//
//        final Element wood = doc.createElement("Wood");
//        wood.appendChild(doc.createTextNode(String.valueOf(bundle.getWood())));
//        rootElement.appendChild(wood);
//
//        final Element stone = doc.createElement("Stone");
//        stone.appendChild(doc.createTextNode(String.valueOf(bundle.getStone())));
//        rootElement.appendChild(stone);
//    }

//    private void createConfiguration( final VulnerableObjektPrototype data, final Document doc, final Element rootElement) {
//        //name elements
//        Element name = doc.createElement("name");
//        name.appendChild(doc.createTextNode(data.getName()));
//        rootElement.appendChild(name);
//
//        Element type = doc.createElement("type");
//        type.appendChild(doc.createTextNode(data.getObjekto().toString()));
//        rootElement.appendChild(type);
//
//
//        //speed elements
//        Element speed = doc.createElement("speed");
//        speed.appendChild(doc.createTextNode(String.valueOf(data.getSpeed())));
//        rootElement.appendChild(speed);
//
//        Element lvl = doc.createElement("lvl");
//        lvl.appendChild(doc.createTextNode(String.valueOf(data.getLevel())));
//        rootElement.appendChild(lvl);
//
//        Element lp = doc.createElement("lp");
//        lp.appendChild(doc.createTextNode(String.valueOf(data.getLevel())));
//        rootElement.appendChild(lp);
//
//        Element atk = doc.createElement("atk");
//        atk.appendChild(doc.createTextNode(String.valueOf(data.getAttack())));
//        rootElement.appendChild(atk);
//
//        Element range = doc.createElement("range");
//        range.appendChild(doc.createTextNode(String.valueOf(data.getRange())));
//        rootElement.appendChild(range);
//
//        Element armour = doc.createElement("armour");
//        armour.appendChild(doc.createTextNode(String.valueOf(data.getArmour())));
//        rootElement.appendChild(armour);
//    }

//    public void writeResearch(final Research research)
//    {
//        try
//        {
//            final DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//            final DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//
//            //root elements
//            final Document doc = docBuilder.newDocument();
//
//            final Element rootElement = doc.createElement("Research");
//            doc.appendChild(rootElement);
//
//            final Element name = doc.createElement("name");
//            name.appendChild(doc.createTextNode(String.valueOf(research.getName())));
//            rootElement.appendChild(name);
//
//            final  Element time = doc.createElement("Time");
//            time.appendChild(doc.createTextNode(String.valueOf(research.getResearchTime())));
//            rootElement.appendChild(time);
//            for(String destin : research.getDestination())
//            {
//                  final Element desti = doc.createElement("destination");
//                  desti.appendChild(doc.createTextNode(destin));
//                  rootElement.appendChild(desti);
//            }
//
//            final  Element config = doc.createElement("Destination");
//            createConfiguration(research.getProtos(), doc, config);
//            rootElement.appendChild(config);
//
//            final  Element prize = doc.createElement("prize");
//            createPriecingBundle(research.getPrize(),doc,prize);
//            rootElement.appendChild(prize);
//
//            //writePrototype the content into xml file
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(doc);
//            StreamResult result =  new StreamResult(new File("C:\\Users\\Michael\\Desktop\\researchTesting.xml"));
//            transformer.transform(source, result);
//
//            System.out.println("Done");
//
//        }catch(ParserConfigurationException pce){
//            pce.printStackTrace();
//        }catch(TransformerException tfe){
//            tfe.printStackTrace();
//        }
//    }
}
