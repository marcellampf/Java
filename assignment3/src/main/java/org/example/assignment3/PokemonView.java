package org.example.assignment3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

public class PokemonView {

    @FXML
    private TextField pokemonNameField;

    @FXML
    private GridPane pokemonInfoGrid;

    @FXML
    private VBox movesContainer;

    @FXML
    private ScrollPane movesScrollPane;

    @FXML
    private Label attacksLabel;

    private final PokemonController pokemonController = new PokemonController();

    @FXML
    private void handleGetPokemonInfo() {
        String pokemonNameOrNumber = pokemonNameField.getText().trim();
        pokemonInfoGrid.setVisible(false); // Hide GridPane initially
        pokemonInfoGrid.getChildren().clear(); // Clear previous results
        movesContainer.getChildren().clear(); // Clear previous moves
        movesScrollPane.setVisible(false); // Hide ScrollPane initially
        attacksLabel.setVisible(false); // Hide Attacks label initially

        if (!pokemonNameOrNumber.isEmpty()) {
            try {
                Pokemon pokemon;
                // Check if the input is a number
                if (pokemonNameOrNumber.matches("\\d+")) {
                    pokemon = pokemonController.getPokemonDataByNumber(Integer.parseInt(pokemonNameOrNumber));
                } else {
                    pokemon = pokemonController.getPokemonData(pokemonNameOrNumber);
                }

                // Add headers
                addRowToGrid("Property", "Value", true);

                // Add rows for each property
                addRowToGrid("Name:", pokemon.getName(), false);
                addRowToGrid("Weight (kg):", String.valueOf(pokemon.getWeight() / 10.0), false); // Convert weight to kg
                addRowToGrid("ID:", String.valueOf(pokemon.getId()), false);

                StringBuilder types = new StringBuilder();
                for (Pokemon.Type type : pokemon.getTypes()) {
                    types.append(type.getType().getName()).append("\n");
                }
                addRowToGrid("Types:", types.toString().trim(), false);

                // Add moves
                for (Pokemon.Move move : pokemon.getMoves()) {
                    Text moveText = new Text(move.getMove().getName());
                    moveText.setFont(Font.font("Arial", 14));
                    moveText.setStyle("-fx-border-color: black; -fx-padding: 5;");
                    movesContainer.getChildren().add(moveText);
                }
                attacksLabel.setVisible(true); // Show Attacks label
                movesScrollPane.setVisible(true); // Show ScrollPane after adding moves

                pokemonInfoGrid.setVisible(true); // Show GridPane after adding data

            } catch (Exception e) {
                e.printStackTrace();
                addRowToGrid("Error fetching data: ", e.getMessage(), false);
                pokemonInfoGrid.setVisible(true); // Show GridPane to display the error
            }
        } else {
            addRowToGrid("Please enter a Pokémon name or number", "", false);
            pokemonInfoGrid.setVisible(true); // Show GridPane to display the message
        }
    }

    private void addRowToGrid(String property, String value, boolean isHeader) {
        int rowIndex = pokemonInfoGrid.getRowCount();

        Text propertyText = new Text(property);
        Text valueText = new Text(value);

        if (isHeader) {
            propertyText.setFont(Font.font("Arial", 16));
            valueText.setFont(Font.font("Arial", 16));
        } else {
            propertyText.setFont(Font.font("Arial", 14));
            valueText.setFont(Font.font("Arial", 14));
        }

        GridPane.setConstraints(propertyText, 0, rowIndex);
        GridPane.setConstraints(valueText, 1, rowIndex);

        propertyText.setStyle("-fx-border-color: black; -fx-padding: 5;");
        valueText.setStyle("-fx-border-color: black; -fx-padding: 5;");

        pokemonInfoGrid.getChildren().addAll(propertyText, valueText);
    }
}
