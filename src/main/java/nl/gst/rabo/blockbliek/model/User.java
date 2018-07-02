package nl.gst.rabo.blockbliek.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;

@Data
@AllArgsConstructor
public class User {
    private String name;
    @JsonIgnore
    private String password;
    private String address;
    private BigInteger balance;
    @JsonIgnore
    private BlokBliekWallet wallet;


}
