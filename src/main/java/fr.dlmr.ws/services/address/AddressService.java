package fr.dlmr.ws.services.address;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dlmr.ws.models.dto.AddressDto;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

@Service
public class AddressService implements iAddressService
{

    public boolean checkAddress(AddressDto address)
    {
        String label, postcode, city;
        label = address.getStreet();
        postcode = address.getZipCode();
        city = address.getCity();

        String url = "https://api-adresse.data.gouv.fr/search/?q=" + label + "&postcode=" + postcode + "&city=" + city;

        try {
            WebClient webClient = WebClient.create(url);
            String response = webClient.get().retrieve().bodyToMono(String.class).block();

            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(response);
            JsonNode features = node.get("features");
            JsonNode score = features.get(0).get("properties").get("score");

            if (score.asDouble() < 0.8) {
                return false;
            }
            else {
                return true;
            }
        } catch (IOException e) {
            return false;
        }
    }
}
