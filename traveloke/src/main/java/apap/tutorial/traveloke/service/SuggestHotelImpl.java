package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.net.URI;


@Service
@Transactional
public class SuggestHotelImpl implements SuggestHotel {
    private final WebClient webClient;
    public SuggestHotelImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.suggestUrl).build();
    }

    public Mono<String> getSuggest(String cityName) {
        String[] temp = cityName.split(" ");
        String kota = "";
        for(String s : temp){
            kota += s;
            kota += "%20";
        }
            return this.webClient.get()
                    .uri(URI.create(
                            "https://hotels-com-free.p.rapidapi.com/suggest/v1.7/json?query="+kota+"&locale=en_US"))
                    .header("x-rapidapi-key", "f0cb37426emshf10661b46735ea4p1585acjsn1cb9be742233")
                    .header("x-rapidapi-host", "hotels-com-free.p.rapidapi.com").retrieve().bodyToMono(String.class);

        }
}
