package com.sda.SpringFacebook.request;

import com.sda.SpringFacebook.model.Range;
import com.sda.SpringFacebook.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequest {

    private Range range;
    private String name;
    private String place;
    private String description;
    private String date;

    private String ownerId;
    private List<String> guests;
}
