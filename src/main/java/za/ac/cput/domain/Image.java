package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Objects;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem itemId;

    private String photo;

    private String name, type;

    protected Image(){}

    public Image(Builder obj) {
        this.id = obj.id;
        this.itemId = obj.itemId;
        this.photo = obj.photo;
        this.name = obj.name;
        this.type = obj.type;
    }

    public long getId() {
        return id;
    }

    public MenuItem getItemId() {
        return itemId;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return id == image.id && Objects.equals(itemId, image.itemId) && Objects.equals(photo, image.photo) && Objects.equals(name, image.name) && Objects.equals(type, image.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, itemId, photo, name, type);
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", photo=" + photo +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public static class Builder{
        private long id;

        private MenuItem itemId;

        private String photo;

        private String name, type;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setItemId(MenuItem itemId) {
            this.itemId = itemId;
            return this;
        }

        public Builder setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder copy(Image obj){
            this.id = obj.id;
            this.itemId = obj.itemId;
            this.photo = obj.photo;
            this.name = obj.name;
            this.type = obj.type;
            return this;
        }

        public Image build(){
            return new Image(this);
        }
    }
}
