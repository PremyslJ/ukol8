package com.engeto.ukol8.contoller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


@RestController
public class RssController {

    @GetMapping("/scifi")                                  //metoda odpovídající jednotlivým URL endpointům
    public String getSciFiArticle() throws IOException {   //metoda získávající obsah článků pro
                                                            // danou kategorii (scifi, romantic, histori).
                                                            // Volají metodu getReadText.

        return getReadText("scifi.txt");
    }

    @GetMapping("/romantic")
    public String getRomanticArticle() throws IOException {
        return getReadText("romantic.txt");
    }

    @GetMapping("/historic")
    public String getHistoricArticle() throws IOException {
        return getReadText("historic.txt");
    }



  //Tato í metoda se stará o načtení obsahu textového souboru s daným názvem.
    private String getReadText(String fileName) throws IOException {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {

            //Metoda scanner.useDelimiter("\\A") nastavuje oddělovač pro scanner,
            // aby přečetl celý obsah souboru jako jeden token.
            scanner.useDelimiter("\\A");

            return scanner.next();
        }
    }
}

