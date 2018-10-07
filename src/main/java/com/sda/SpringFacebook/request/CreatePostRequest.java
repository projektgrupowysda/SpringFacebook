package com.sda.SpringFacebook.request;

import com.sda.SpringFacebook.enums.RangeOfPost;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class CreatePostRequest {

    private String postContent;

    private RangeOfPost rangeOfPost;
}
