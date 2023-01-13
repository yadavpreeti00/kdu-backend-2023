package org.question3;

public class Consumer {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    private Integer tier;

    public Consumer(Long id,String name,Integer tier){
        this.id=id;
        this.name=name;
        this.tier=tier;
    }

}

