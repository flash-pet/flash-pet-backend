package com.senac.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "rate_index")
public class Rate {
    @Id
    private String id;

    @Field(type = FieldType.Double)
    private Double avg;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<IndividualRate> individualRates;


}
