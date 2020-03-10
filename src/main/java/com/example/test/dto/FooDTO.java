
package com.example.test.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "foo",
    "bar",
    "baz"
})
public class FooDTO {

    @JsonProperty("foo")
    private String foo;
    @JsonProperty("bar")
    private Integer bar;
    @JsonProperty("baz")
    private Boolean baz;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The foo
     */
    @JsonProperty("foo")
    public String getFoo() {
        return foo;
    }

    /**
     * 
     * @param foo
     *     The foo
     */
    @JsonProperty("foo")
    public void setFoo(String foo) {
        this.foo = foo;
    }

    public FooDTO withFoo(String foo) {
        this.foo = foo;
        return this;
    }

    /**
     * 
     * @return
     *     The bar
     */
    @JsonProperty("bar")
    public Integer getBar() {
        return bar;
    }

    /**
     * 
     * @param bar
     *     The bar
     */
    @JsonProperty("bar")
    public void setBar(Integer bar) {
        this.bar = bar;
    }

    public FooDTO withBar(Integer bar) {
        this.bar = bar;
        return this;
    }

    /**
     * 
     * @return
     *     The baz
     */
    @JsonProperty("baz")
    public Boolean getBaz() {
        return baz;
    }

    /**
     * 
     * @param baz
     *     The baz
     */
    @JsonProperty("baz")
    public void setBaz(Boolean baz) {
        this.baz = baz;
    }

    public FooDTO withBaz(Boolean baz) {
        this.baz = baz;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public FooDTO withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(foo).append(bar).append(baz).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FooDTO) == false) {
            return false;
        }
        FooDTO rhs = ((FooDTO) other);
        return new EqualsBuilder().append(foo, rhs.foo).append(bar, rhs.bar).append(baz, rhs.baz).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
