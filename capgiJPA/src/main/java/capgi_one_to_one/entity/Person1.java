package capgi_one_to_one.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Person1 {
    @Id
    private int personID;
    private String name;
}
