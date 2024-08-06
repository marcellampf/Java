
package org.example.assignment3;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Pokemon {
    private String name;
    private int weight;

    @SerializedName("base_experience")
    private int baseExperience;

    private int height;
    private int id;
    private List<Type> types;
    private List<Move> moves;
    private List<Form> forms;

    @SerializedName("sprites")
    private Sprites sprites;

    public static class Sprites {
        @SerializedName("front_default")
        private String frontDefault;

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }
    }

    public static class Type {
        private TypeDetail type;

        public static class TypeDetail {
            private String name;

            public String getName() {
                return name;
            }
        }

        public TypeDetail getType() {
            return type;
        }
    }

    public static class Move {
        private MoveDetail move;

        public static class MoveDetail {
            private String name;

            public String getName() {
                return name;
            }
        }

        public MoveDetail getMove() {
            return move;
        }
    }

    public static class Form {
        private String name;

        public String getName() {
            return name;
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<Form> getForms() {
        return forms;
    }

    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }
}

