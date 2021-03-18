package fr.janis.pintium.data;

public class EntityKilled implements IEntityKilled{

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
