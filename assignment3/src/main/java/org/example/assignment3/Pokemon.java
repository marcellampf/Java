package org.example.assignment3;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Pokemon {
    // Name of the Pokémon
    private String name;
    // Weight of the Pokémon
    private int weight;

    // Base experience of the Pokémon (mapped from JSON API)
    @SerializedName("base_experience")
    private int baseExperience;

    // Height of the Pokémon
    private int height;
    // ID of the Pokémon
    private int id;
    // List of types of the Pokémon
    private List<Type> types;
    // List of moves of the Pokémon
    private List<Move> moves;
    // List of forms of the Pokémon
    private List<Form> forms;

    // Inner class to represent the type of the Pokémon
    public static class Type {
        // Details of the type of the Pokémon
        private TypeDetail type;

        // Inner class to represent the details of the type
        public static class TypeDetail {
            // Name of the type
            private String name;

            public String getName() {
                return name;
            }
        }

        public TypeDetail getType() {
            return type;
        }
    }

    // Inner class to represent the move of the Pokémon
    public static class Move {
        // Details of the move of the Pokémon
        private MoveDetail move;

        // Inner class to represent the details of the move
        public static class MoveDetail {
            // Name of the move
            private String name;

            public String getName() {
                return name;
            }
        }

        public MoveDetail getMove() {
            return move;
        }
    }

    // Inner class to represent the form of the Pokémon
    public static class Form {
        // Name of the form
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
}
