package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import lombok.Data;

import static java.lang.Integer.parseInt;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {

    @JsonProperty("addtocart_1.EnteredQuantity")
    private int addtocart;

    @JsonProperty("giftcard_1.Message")
    private String msg;

    @JsonProperty("giftcard_1.RecipientEmail")
    private String recMail;

    @JsonProperty("giftcard_1.RecipientName")
    private String recName;

    @JsonProperty("giftcard_1.SenderName")
    private String sendName;

    @JsonProperty("giftcard_1.SenderEmail")
    private String sendMail;

    private int cardIndex;

    private String apiSuffix;

    public Form(int numbers, int index, String apiSuffix) {
        this.addtocart = numbers;
        Faker faker1 = new Faker();
        Faker faker2 = new Faker();
        this.msg = faker1.lorem().sentence();
        this.recMail = faker2.internet().emailAddress();
        this.recName = faker2.name().firstName();
        this.sendName = faker1.name().firstName();
        this.sendMail = faker2.internet().emailAddress();
        this.cardIndex = index;
        this.apiSuffix = apiSuffix;
    }

    public Form(int numbers, String apiSuffix) {
        this.addtocart = numbers;
        Faker faker1 = new Faker();
        Faker faker2 = new Faker();
        this.msg = faker1.lorem().sentence();
        this.recMail = faker2.internet().emailAddress();
        this.recName = faker2.name().firstName();
        this.sendName = faker1.name().firstName();
        this.sendMail = faker2.internet().emailAddress();
        this.cardIndex = parseInt(apiSuffix.substring(apiSuffix.length() - 3, apiSuffix.length() - 2));
        this.apiSuffix = apiSuffix;
    }

    public int getAddtocart() { return addtocart; }

    public void setAddtocart(int addtocart) {
        this.addtocart = addtocart;
    }

    public String getMsg() { return msg; }

    public String getRecMail() { return recMail; }

    public String getRecName() { return recName; }

    public int getCardIndex() {
        return cardIndex;
    }

    public String getSendName() {
        return sendName;
    }

    public String getSendMail() {
        return sendMail;
    }

    public String getApiSuffix() {
        return apiSuffix;
    }

    public void setApiSuffix(String apiSuffix) {
        this.apiSuffix = apiSuffix;
    }

    @Override
    public String toString() {
        return "Form{" +
                "addtocart=" + addtocart +
                ", msg='" + msg + '\'' +
                ", recMail='" + recMail + '\'' +
                ", recName='" + recName + '\'' +
                ", sendName='" + sendName + '\'' +
                ", sendMail='" + sendMail + '\'' +
                '}';
    }
}
