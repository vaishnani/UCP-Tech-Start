package io.javaspring.isthesiteup;

public class Topics {

    private String id;
    private String name;
    private String descriptions;

    public Topics(){

    }

    public Topics(String id, String name, String descriptions){
        super();
        this.id = id;
        this.name = name;
        this.descriptions = descriptions;
    }  
    

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return this.descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }
}
