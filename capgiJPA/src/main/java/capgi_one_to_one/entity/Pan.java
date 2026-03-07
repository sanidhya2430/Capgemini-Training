package capgi_one_to_one.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Pan {
    @Id
    private int panNumber;
    private String panAddress;

    @OneToOne
    private Person1 person1;

}
