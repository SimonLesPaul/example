import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class CreatePatterns {
	public static String[][][] a = Patterns.mustera;
	public static String[][][] b = Patterns.musterb;
	public static ArrayList<List<Node>> musterVektor1(Document dom){
		ArrayList<List<Node>> mv = new ArrayList<List<Node>>();
		for (String[][] patternString : a){
			List<Node> pattern = new ArrayList<Node>();
			for (String[] noteString : patternString){
				Node note = dom.createElement("note");
				Node duration = dom.createElement("duration");
				duration.setTextContent(noteString[0]);
				note.appendChild(duration);
				Node type = dom.createElement("type");
				type.setTextContent(noteString[1]);
				note.appendChild(type);
				Node dot;
				if (noteString[2].equals("dot")){
					dot = dom.createElement("dot");
					note.appendChild(dot);
				}
				Node rest;
				if (noteString[3].equals("rest")){
					rest = dom.createElement("rest");
					note.appendChild(rest);
				}
				Node tie1;
				if (!noteString[4].isEmpty()){
					tie1 = dom.createElement("tie");
					((Element)tie1).setAttribute("type", noteString[4]);
					note.appendChild(tie1);
				}
				Node tie2;
				if (!noteString[5].isEmpty()){
					tie2 = dom.createElement("tie");
					((Element)tie2).setAttribute("type", noteString[5]);
					note.appendChild(tie2);
				}
				Node beam1;
				if (!noteString[6].isEmpty()){
					beam1 = dom.createElement("beam");
					((Element)beam1).setAttribute("number", noteString[6]);
					beam1.setTextContent(noteString[8]);
					note.appendChild(beam1);
				}
				Node beam2;
				if (!noteString[7].isEmpty()){
					beam2 = dom.createElement("beam");
					((Element)beam2).setAttribute("number", noteString[6]);
					beam2.setTextContent(noteString[9]);
					note.appendChild(beam2);
				}
				Node notations = dom.createElement("notations");
				Node tied1;
				if (!noteString[4].isEmpty()){
					tied1 = dom.createElement("tied");
					((Element)tied1).setAttribute("type", noteString[4]);
					notations.appendChild(tied1);
				}
				Node tied2;
				if (!noteString[5].isEmpty()){
					tied2 = dom.createElement("tied");
					((Element)tied2).setAttribute("type", noteString[5]);
					notations.appendChild(tied2);
				}
				if (notations.hasChildNodes())
					note.appendChild(notations);
				pattern.add(note);
			}
			mv.add(pattern);
		}
		return mv;
	}
	public static ArrayList<List<Node>> musterVektor2(Document dom){
		ArrayList<List<Node>> mv = new ArrayList<List<Node>>();
		for (String[][] patternString : b){
			List<Node> pattern = new ArrayList<Node>();
			for (String[] noteString : patternString){
				Node note = dom.createElement("note");
				Node duration = dom.createElement("duration");
				duration.setTextContent(noteString[0]);
				note.appendChild(duration);
				Node type = dom.createElement("type");
				type.setTextContent(noteString[1]);
				note.appendChild(type);
				Node dot;
				if (noteString[2].equals("dot")){
					dot = dom.createElement("dot");
					note.appendChild(dot);
				}
				Node rest;
				if (noteString[3].equals("rest")){
					rest = dom.createElement("rest");
					note.appendChild(rest);
				}
				Node tie1;
				if (!noteString[4].isEmpty()){
					tie1 = dom.createElement("tie");
					((Element)tie1).setAttribute("type", noteString[4]);
					note.appendChild(tie1);
				}
				Node tie2;
				if (!noteString[5].isEmpty()){
					tie2 = dom.createElement("tie");
					((Element)tie2).setAttribute("type", noteString[5]);
					note.appendChild(tie2);
				}
				Node beam1;
				if (!noteString[6].isEmpty()){
					beam1 = dom.createElement("beam");
					((Element)beam1).setAttribute("number", noteString[6]);
					beam1.setTextContent(noteString[8]);
					note.appendChild(beam1);
				}
				Node beam2;
				if (!noteString[7].isEmpty()){
					beam2 = dom.createElement("beam");
					((Element)beam2).setAttribute("number", noteString[6]);
					beam2.setTextContent(noteString[9]);
					note.appendChild(beam2);
				}
				Node notations = dom.createElement("notations");
				Node tied1;
				if (!noteString[4].isEmpty()){
					tied1 = dom.createElement("tied");
					((Element)tied1).setAttribute("type", noteString[4]);
					notations.appendChild(tied1);
				}
				Node tied2;
				if (!noteString[5].isEmpty()){
					tied2 = dom.createElement("tied");
					((Element)tied2).setAttribute("type", noteString[5]);
					notations.appendChild(tied2);
				}
				if (notations.hasChildNodes())
					note.appendChild(notations);
				pattern.add(note);
			}
			mv.add(pattern);
		}
		return mv;
	}
	public static void main(String[] args){
		Document dom;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.newDocument();
			ArrayList<List<Node>> al = musterVektor1(dom);
			System.out.println(al.size());
			for (List<Node> l : al){
				System.out.println("\t"+l.size());
				for (Node n : l){
					System.out.println("\t\t"+n.getChildNodes().getLength());
				}
			}
        } catch (ParserConfigurationException pce) {
            System.out.println(pce.getMessage());
        }
	}
}
