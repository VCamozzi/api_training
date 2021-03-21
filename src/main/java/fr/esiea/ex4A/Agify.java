package fr.esiea.ex4A;

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
    private String name;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("count")
    private Integer count;
    @JsonProperty("country_id")
    private String countryId;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Agify withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("age")
    public void setAge(Integer age) {
        this.age = age;
    }

    public Agify withAge(Integer age) {
        this.age = age;
        return this;
    }

    @JsonProperty("count")
    public Integer getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Integer count) {
        this.count = count;
    }

    public Agify withCount(Integer count) {
        this.count = count;
        return this;
    }

    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Agify withCountryId(String countryId) {
        this.countryId = countryId;
        return this;
    }
}
