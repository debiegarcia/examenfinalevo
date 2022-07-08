package com.psycho.psychohelp.publication.resource;

import com.psycho.psychohelp.psychologist.resource.PsychologistResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublicationResource {
    private Long id;
    private String title;
    private String tags;
    private String description;
    private String photoUrl;
    private String content;
    private PsychologistResource psychologist;
}
