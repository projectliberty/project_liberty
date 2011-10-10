package de.claiming.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.claiming.model.Image;
import de.claiming.model.Person;

public class PersonHandler extends DefaultHandler {
    
    private StringBuffer buffer = new StringBuffer();
    
    private ArrayList<Person> personList;
    private Person person;
    private ArrayList<Image> personImagesList;
    private Image personImage;
    
    @Override
    public void startElement(String namespaceURI, String localName,
            String qName, Attributes atts) throws SAXException {
        
        buffer.setLength(0);
        
        if (localName.equals("people")) {
            personList = new ArrayList<Person>();
        }
        else if (localName.equals("person")) {
            person = new Person();
        }
        else if (localName.equals("images")) {
            personImagesList = new ArrayList<Image>();
        }
        else if (localName.equals("image")) {
            personImage = new Image();
            personImage.type = atts.getValue("type");
            personImage.url = atts.getValue("url");
            personImage.size = atts.getValue("size");
            personImage.width = Integer.parseInt(atts.getValue("width"));
            personImage.height = Integer.parseInt(atts.getValue("height"));
        }

    }
    
    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException {
        
        if (localName.equals("person")) {
            personList.add(person);
        }
        else if (localName.equals("score")) {
            person.score = buffer.toString();
        }
        else if (localName.equals("popularity")) {
            person.popularity = buffer.toString();
        }
        else if (localName.equals("name")) {
            person.name = buffer.toString();
        }
        else if (localName.equals("id")) {
            person.id = buffer.toString();
        }
        else if (localName.equals("biography")) {
            person.biography = buffer.toString();
        }
        else if (localName.equals("url")) {
            person.url = buffer.toString();
        }
        else if (localName.equals("version")) {
            person.version = buffer.toString();
        }
        else if (localName.equals("last_modified_at")) {
            person.lastModifiedAt = buffer.toString();
        }    
        else if (localName.equals("image")) {
            personImagesList.add(personImage);
        }    
        else if (localName.equals("images")) {
            person.imagesList = personImagesList;
        }
        
    }
    
    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }
        
    public ArrayList<Person> retrievePersonList() {
        return personList;
    }
    
}
