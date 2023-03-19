package APItests;

import APItests.APIdata.Characters;
import APItests.APIdata.Result;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static APItests.APIdata.GetCharacters.getCharacters;

public class RickyAndMortyTest {
        List<String> urls = new ArrayList<>();
        String url = "https://rickandmortyapi.com/api/character";
    @BeforeMethod
    public void getURLs() {
        urls.add(url);
        while(true) {
            Characters charactersList = getCharacters(url);

            if (!Objects.equals(charactersList.getInfo().getNext(),null)) {
                urls.add(charactersList.getInfo().getNext());
                url = charactersList.getInfo().getNext();
            } else {
                break;
            }
        }
        System.out.println(urls);
    }

    @Test
    public void getAllNames(){

        List<String> listOfNames = new ArrayList<>();
        for(String l: urls){
            Characters charactersList = getCharacters(l);
            for(Result r : charactersList.getResults()){
                System.out.println("name: " + r.getName());
                System.out.println("name: " + r.getStatus());
                System.out.println("name: " + r.getSpecies());
                System.out.println("=======================");
                listOfNames.add(r.getName());
            }
        }
        System.out.println("Characters in list: " + listOfNames.size());
    }
    }

