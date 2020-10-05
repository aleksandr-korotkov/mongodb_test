package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor(staticName = "of")
@Accessors(chain = true)
@Document(collection = "workspaces")
public class Workspace {

    @Id
    private String id;
    @Indexed
    private int unit;
    private int seat;
    private String serialNumber;
    private OSFamily osFamily;
}
