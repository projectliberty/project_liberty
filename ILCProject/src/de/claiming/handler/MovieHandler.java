package de.claiming.handler;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import de.claiming.model.Image;
import de.claiming.model.Movie;

public class MovieHandler extends DefaultHandler {
    
    private StringBuffer buffer = new StringBuffer();
    
    private ArrayList<Movie> movieList;
    private Movie movie;
    private ArrayList<Image> movieImageList;
    private Image movieImage;
    
    @Override
    public void startElement(String namespaceURI, String localName,
            String qName, Attributes atts) throws SAXException {
        
        buffer.setLength(0);
        
        if (localName.equals("movie")) {
            movieList = new ArrayList<Movie>();
        }
        else if (localName.equals("movie")) {
            movie = new Movie();
        }
        else if (localName.equals("images")) {
            movieImageList = new ArrayList<Image>();
        }
        else if (localName.equals("image")) {
            movieImage = new Image();
            movieImage.type = atts.getValue("type");
            movieImage.url = atts.getValue("url");
            movieImage.size = atts.getValue("size");
            movieImage.width = Integer.parseInt(atts.getValue("width"));
            movieImage.height = Integer.parseInt(atts.getValue("height"));
        }

    }
    
    @Override
    public void endElement(String uri, String localName, String qName)throws SAXException {
        
        if (localName.equals("person")) {
            movieList.add(movie);
        }
        else if (localName.equals("score")) {
            movie.score = buffer.toString();
        }
        else if (localName.equals("popularity")) {
            movie.popularity = buffer.toString();
        }
        else if (localName.equals("name")) {
            movie.name = buffer.toString();
        }
        else if (localName.equals("id")) {
            movie.id = buffer.toString();
        }
        else if (localName.equals("original_name")) {
            movie.originalName = buffer.toString();
        }
        else if (localName.equals("url")) {
            movie.url = buffer.toString();
        }
        else if (localName.equals("version")) {
            movie.version = buffer.toString();
        }
        else if (localName.equals("last_modified_at")) {
            movie.lastModifiedAt = buffer.toString();
        }    
        else if (localName.equals("image")) {
            movieImageList.add(movieImage);
        }    
        else if (localName.equals("images")) {
            movie.imagesList = movieImageList;
        }
        
    }
    
    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }
        
    public ArrayList<Movie> retrieveMoviesList() {
        return movieList;
    }
    
}
