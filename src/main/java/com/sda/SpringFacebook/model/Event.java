package com.sda.SpringFacebook.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "guests")
@ToString(exclude = "guests")
@Document(collection = "event")
public class Event {

    @Id
    private String id;

    private Range range;
    private String name;
    private String place;
    private String description;
    private String date;

    private String ownerId;
    private List<String> guests;
}

