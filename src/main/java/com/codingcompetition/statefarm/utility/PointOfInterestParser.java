package com.codingcompetition.statefarm.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.codingcompetition.statefarm.model.PointOfInterest;

public class PointOfInterestParser {

	private static Logger log = Logger.getLogger(PointOfInterestParser.class.getName());
    // Stacks for storing the elements and objects.

    public List<PointOfInterest> parse(String fileName) throws IOException, SAXException, ParserConfigurationException
    {
    	List<PointOfInterest> parsedNodes = new ArrayList<>();
    	if (fileName.charAt(0) == '/') {
    	      fileName = fileName.substring(1);
    	    }
    	ClassLoader classLoader = getClass().getClassLoader();
    	File inputFile = new File(classLoader.getResource(fileName).getFile());
    	//File inputFile = new File(fileName);
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("node");
        
        for(int i =0;i<nList.getLength();i++)
        {
        	if(i % 1000 == 0 && i!=0)
        	{
        		log.info("Parsed " + i + " nodes.");
        	}
        	Node currNode = nList.item(i);
        	if(currNode.getNodeType() == Node.ELEMENT_NODE)
    		{
    			Element e = (Element) currNode;
    			PointOfInterest poi = new PointOfInterest();
    			poi.setLatitude(e.getAttribute("lat"));
    			poi.setLongitude(e.getAttribute("lon"));
    			NodeList currNodeData = e.getChildNodes();
            	for(int j =0;j<currNodeData.getLength();j++)
            	{
            		Node currDataNode = currNodeData.item(j);
            		if(currDataNode.getNodeType() == Node.ELEMENT_NODE)
            		{
            			Element ec = (Element) currDataNode;
            			//System.out.println(ec.getAttribute("k") + "|" +ec.getAttribute("v"));
            			poi.addDescriptor(ec.getAttribute("k"), ec.getAttribute("v"));
            		}
            	}
            	parsedNodes.add(poi);
    		}
        	
        	
        }
    	
    	
    	
    	
        return parsedNodes;
    }

}
