
package request;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "Othr"
})
public class FinInstnId {

    @JsonProperty("Othr")
    private request.Othr Othr;

    /**
     * 
     * @return
     *     The Othr
     */
    @JsonProperty("Othr")
    public request.Othr getOthr() {
        return Othr;
    }

    /**
     * 
     * @param Othr
     *     The Othr
     */
    @JsonProperty("Othr")
    public void setOthr(request.Othr Othr) {
        this.Othr = Othr;
    }

}
