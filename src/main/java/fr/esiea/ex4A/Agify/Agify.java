package fr.esiea.ex4A.Agify;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "age",
    "count",
    "country_id"
})
public class Agify {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("age")
    private final Integer age;
    @JsonProperty("count")
    private final Integer count;
    @JsonProperty("country_id")
    private final String countryId;

    public Agify(String name, Integer age, Integer count, String countryId) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.countryId = countryId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

}
