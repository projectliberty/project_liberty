package de.claiming;

import java.util.ArrayList;
import android.util.Log;
import de.claiming.model.Person;


public class PersonSeeker extends GenericSeeker<Person> {
        
    private static final String PERSON_SEARCH_PATH = "Person.search/";
    
    public ArrayList<Person> find(String query) {
        ArrayList<Person> PersonsList = retrievePersonsList(query);
        return PersonsList;
    }
    
    public ArrayList<Person> find(String query, int maxResults) {
        ArrayList<Person> PersonsList = retrievePersonsList(query);
        return retrieveFirstResults(PersonsList, maxResults);
    }
    
    private ArrayList<Person> retrievePersonsList(String query) {
        String url = constructSearchUrl(query);
        String response = httpRetriever.retrieve(url);
        Log.d(getClass().getSimpleName(), response);
        return xmlParser.parsePeopleResponse(response);
    }

    @Override
    public String retrieveSearchMethodPath() {
        return PERSON_SEARCH_PATH;
    }

}
