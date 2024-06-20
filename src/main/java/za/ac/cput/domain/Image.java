package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem itemId;

    @Lob
    @Column(name = "image_data", length = 1000)
    private byte[] photo;

    private String name, type;

}
