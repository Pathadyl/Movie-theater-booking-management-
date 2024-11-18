package model;

public class Theater {
    private int id;
    private String name;
    private String location;
    private String avatar_path;
    private String image_path;
    private boolean visibility;

    public Theater(int id, String name, String location, String avatarPath, String coverPath, boolean visibility) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.avatar_path = avatarPath;
        this.image_path = coverPath;
        this.visibility = visibility;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar_path() {
        return avatar_path;
    }

    public void setAvatar_path(String avatar_path) {
        this.avatar_path = avatar_path;
    }

    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    
    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

}
