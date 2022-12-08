package com.network.backend.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class User {
    public UUID id;
    @NotBlank
    public String username;
    public String first_name;
    public String last_name;
    @NotBlank
    public String password;
    public String email;



    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("first_name") String first_name,
                @JsonProperty("last_name") String last_name,
                @JsonProperty("password") String password,
                @JsonProperty("email") String email
                ) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.email = email;
    }


    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirst_name() {return first_name;}

    public String getLast_name() {return last_name;}

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
