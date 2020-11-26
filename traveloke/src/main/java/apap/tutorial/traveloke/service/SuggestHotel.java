package apap.tutorial.traveloke.service;

import reactor.core.publisher.Mono;

public interface SuggestHotel {
    Mono<String> getSuggest(String cityName);
}
